package psu.edu.groupproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupProjectController {
    @GetMapping("/")
        public String showHome() {
            return "home";
        }
    }


