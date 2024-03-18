package com.example.demo.Controllers.Web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}