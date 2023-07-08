package com.miniproject0705.controller;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor // final이 붙은 인스턴스를 매개로 하는 signUpController 생성자가 만들어진다.
public class SignUpController {
    private final MemberServiceImpl memberService;

    @GetMapping("/signUp")
    public String getSignUp(@ModelAttribute("formData") MemberInfoDTO memberInfoDTO) {
        return"signUpPage";
    }

    @PostMapping("/signUp")
    public String postSignUp(@ModelAttribute("formData") MemberInfoDTO memberInfoDTO) {
        memberService.save(memberInfoDTO);
        return "redirect:/";
    }

}
