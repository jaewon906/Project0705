package com.miniproject0705.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FindController {
    private final MemberService memberService;

    @GetMapping("findIdPw")
    public String getFindAll(Model model) {
        List<MemberInfoDTO> memberInfoDTOList = memberService.findAll();
        model.addAttribute("findList", memberInfoDTOList);
        return "findInfoPage";
    }

    @GetMapping("findIdPw/{id}")
//  REST API 를 사용할 때 {경로} 상의 값을 @PathVariable 이라는 어노테이션을 사용해서
//  id 변수에 담았습니다.
    public String findByID(@PathVariable Long id, Model model) {
        MemberInfoDTO memberInfoDTO = memberService.findById(id);
        model.addAttribute("member",memberInfoDTO);
        return "detailPage";

    }

}
