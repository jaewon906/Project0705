package com.miniproject0705.controller;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UpdateController {
    private final MemberService memberService;
    @GetMapping("/update") // 링크를 타고 들어왔으면 Get
//    로그인 되어있으면 페이지를 넘길 때 마다 로그아웃이 되지 않도록 세션에 내 정보를 넣어두는데 LoginController에서 UserId를 넣었음
//    해당 정보를 서비스계층에 넘겨서 변경 작업을 수행
//    변경된 값을 리포지토리 계층에 넘겨서 엔티티 변환 후 DB에 저장.
//
    public String getUpdate(HttpSession session, Model model) {
        String loginId =(String) session.getAttribute("userId");
        MemberInfoDTO memberInfoDTO = memberService.updateForm(loginId);
        model.addAttribute("updateMember", memberInfoDTO);
        return "updatePage";
    }

    @PostMapping("/update")
    public String postUpdate(@ModelAttribute MemberInfoDTO memberInfoDTO) {
        memberService.update(memberInfoDTO);
        return "redirect:/update" + memberInfoDTO.getNo();
    }

}
