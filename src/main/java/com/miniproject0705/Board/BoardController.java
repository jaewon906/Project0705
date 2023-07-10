package com.miniproject0705.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board") //@RequestMapping 사용하면 @GetMapping에 풀 URL을 적을 필요가 없어짐
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/save") // @RequestMapping에 의해 "board/save"로 인식
    public String saveForm(@ModelAttribute("formData") BoardDomain boardDomain) {
        return "boardSavePage";
    }
    @PostMapping("/save") // @RequestMapping에 의해 "board/save"로 인식
    public String save(@ModelAttribute("formData") BoardDomain boardDomain) {
        boardService.save(boardDomain);
        return "redirect:/";
    }
}
