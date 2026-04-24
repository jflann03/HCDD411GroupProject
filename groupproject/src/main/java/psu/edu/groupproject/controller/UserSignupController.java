package psu.edu.groupproject.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/signup")
public class UserSignupController {

    private Logger logger = Logger.getLogger(getClass().getName());

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserSignupController(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/showSignupForm")
    public String showSignupForm() {
        return "signup-form";
    }

    @PostMapping("/processSignupForm")
    public String processSignupForm(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            HttpSession session,
            Model theModel) {

        logger.info("Processing signup form for user: " + userName);

        userName = userName.trim().toLowerCase();

        if (!password.equals(confirmPassword)) {
            theModel.addAttribute("signupError", "Passwords do not match.");
            return "signup-form";
        }

        Integer existingUserCount = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM users WHERE username = ?",
                Integer.class,
                userName
        );

        if (existingUserCount != null && existingUserCount > 0) {
            theModel.addAttribute("signupError", "Username already exists.");
            return "signup-form";
        }

        String encodedPassword = passwordEncoder.encode(password);

        jdbcTemplate.update(
                "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)",
                userName,
                encodedPassword,
                false
        );

        /*
         * Give every new signup the basic supervisor role.
         * The account is still disabled until approved.
         */
        jdbcTemplate.update(
                "INSERT INTO authorities (username, authority) VALUES (?, ?)",
                userName,
                "ROLE_SUPERVISOR"
        );

        session.setAttribute(
                "signupMessage",
                "Signup request submitted successfully. A manager or admin must approve your account before you can log in."
        );

        return "redirect:/signup/signupConfirmation";
    }

    @GetMapping("/signupConfirmation")
    public String signupConfirmation() {
        return "signup-confirmation";
    }

    @GetMapping("/pending")
    public String showPendingUsers(Model theModel) {

        List<Map<String, Object>> pendingUsers = jdbcTemplate.queryForList(
                """
                SELECT u.username, a.authority
                FROM users u
                LEFT JOIN authorities a ON u.username = a.username
                WHERE u.enabled = false
                ORDER BY u.username
                """
        );

        theModel.addAttribute("pendingUsers", pendingUsers);

        return "pending-users";
    }

    @PostMapping("/approve")
    public String approveUser(@RequestParam("username") String userName) {

        logger.info("Approving user: " + userName);

        userName = userName.trim().toLowerCase();

        jdbcTemplate.update(
                "UPDATE users SET enabled = true WHERE username = ?",
                userName
        );

        return "redirect:/signup/pending";
    }

    @PostMapping("/deny")
    public String denyUser(@RequestParam("username") String userName) {

        logger.info("Denying user: " + userName);

        userName = userName.trim().toLowerCase();

        jdbcTemplate.update(
                "DELETE FROM authorities WHERE username = ?",
                userName
        );

        jdbcTemplate.update(
                "DELETE FROM users WHERE username = ?",
                userName
        );

        return "redirect:/signup/pending";
    }

    @GetMapping("/manage")
    public String manageUsers(Model theModel, Authentication authentication) {

        List<Map<String, Object>> users = jdbcTemplate.queryForList(
                """
                SELECT u.username, u.enabled, a.authority
                FROM users u
                LEFT JOIN authorities a ON u.username = a.username
                ORDER BY u.username
                """
        );

        theModel.addAttribute("users", users);
        theModel.addAttribute("currentUsername", authentication.getName());

        return "manage-users";
    }

    @PostMapping("/delete")
    public String deleteUser(
            @RequestParam("username") String userName,
            Authentication authentication) {

        logger.info("Deleting user: " + userName);

        userName = userName.trim().toLowerCase();

        if (authentication.getName().equalsIgnoreCase(userName)) {
            throw new RuntimeException("You cannot delete your own account while logged in.");
        }

        jdbcTemplate.update(
                "DELETE FROM authorities WHERE username = ?",
                userName
        );

        jdbcTemplate.update(
                "DELETE FROM users WHERE username = ?",
                userName
        );

        return "redirect:/signup/manage";
    }
}