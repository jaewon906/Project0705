package com.miniproject0705.controller;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {
    private final MemberService memberService;

    @GetMapping("logIn")
    public String getLogin(@ModelAttribute("formData") MemberInfoDTO memberInfoDTO) {
        return "logInPage";
    }

    @PostMapping("logIn")
    // 로그인을 유지하기 위해 session 스토리지 사용
    public String postLogin(@ModelAttribute("formData") MemberInfoDTO memberInfoDTO, HttpSession session) {
        MemberInfoDTO loginResult = memberService.signIn(memberInfoDTO);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getUserId());
            return "logInPage";
        }
        else {

            return "logInPage";
        }

    }
}
