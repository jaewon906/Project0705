package com.miniproject0705.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public String getSignUp() {
        return"signUpPage";
    }
    @PostMapping("/signUp")
    public String postSignUp(@RequestParam("id")String id, @RequestParam("password")String password, @RequestParam("nickname") String nickname) {
        return"signUpPage";
    }

}
