package com.miniproject0705.controller;

import com.miniproject0705.domain.MemberInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public String getSignUp(@ModelAttribute("formData") MemberInfoDTO memberInfoDTO) {
        return"signUpPage";
    }

    @PostMapping("/signUp")
    public String postSignUp(@ModelAttribute("formData") MemberInfoDTO memberInfoDTO) {
        return "signUpPage";
    }

}
