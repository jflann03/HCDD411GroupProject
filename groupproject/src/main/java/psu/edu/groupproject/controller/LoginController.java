package psu.edu.groupproject.controller;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "login";
    }

    //add request mapping for access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
