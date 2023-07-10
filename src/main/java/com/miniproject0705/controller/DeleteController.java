package com.miniproject0705.controller;

import com.miniproject0705.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class DeleteController {
    private final MemberService memberService;
    @GetMapping("findIdPw/delete/{id}")
    public String getDelete(@PathVariable Long id) {
        memberService.deleteById(id);
        return "findInfoPage";
    }
}
