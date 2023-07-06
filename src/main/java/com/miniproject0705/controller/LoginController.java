package com.miniproject0705.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("logIn")
    public String getLogin() {
        return "logInPage";
    }
}
