package com.miniproject0705.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board") //@RequestMapping 사용하면 @GetMapping에 풀 URL을 적을 필요가 없어짐
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save") // @RequestMapping에 의해 "board/save"로 인식
    public String saveForm(@ModelAttribute("formData") BoardDomain boardDomain) {
        return "boardSave";
    }

    @PostMapping("/save") // @RequestMapping에 의해 "board/save"로 인식
    public String save(@ModelAttribute("formData") BoardDomain boardDomain) throws IOException { // transferTo() 때문에 예외처리함
        boardService.save(boardDomain);
        return "redirect:/";
    }

    @GetMapping("")
    public String findAll(Model model) { //전체 게시글 조회
        List<BoardDomain> boardDomainList = boardService.findAll();
        model.addAttribute("boardList", boardDomainList);
        return "boardList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable Long id, Model model, @PageableDefault(page = 1) Pageable pageable) { // 특정 게시글 조회
        boardService.updateHits(id);
        BoardDomain boardDomain = boardService.findById(id);
        model.addAttribute("selected", boardDomain);
        model.addAttribute("page", pageable.getPageNumber());
        return "boardSelected";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDomain boardDomain = boardService.findById(id);
        model.addAttribute("updating", boardDomain);
        return "boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDomain boardDomain, Model model) { // 게시판 수정
        BoardDomain board = boardService.update(boardDomain);
//        return "redirect:/board" + boardDomain.getPageNum(); // 이 방법도 가능하지만 리다이렉트 이기 때문에 조회수가 늘어날 수도 있다.
        return "redirect:/board";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id) { // 게시판 삭제
        boardService.delete(id);
        return "redirect:/board";

    }

    @GetMapping("/paging")
    // board/paging?page=2 쿼리스트링에서 page=2 부분을 pageable객체가 받아 줄 것이다.
    // 기본값을 설정해야 내가 처음에 설정한 페이지 개수가 나오게 된다.
    public String pagingForm(@PageableDefault(page = 1) Pageable pageable, Model model) {
        Page<BoardDomain> boardList = boardService.paging(pageable); //DTO가 담긴 page 인터페이스 객체 생성
        int blockLimit = 3; // 하단 페이지 번호 개수
        int startPage = (((int)Math.ceil((double)pageable.getPageNumber() / blockLimit))-1) * blockLimit + 1;
        int endPage = ((startPage - blockLimit -1) < boardList.getTotalPages()) ? startPage + blockLimit -1 :boardList.getTotalPages();
        model.addAttribute("boardList", boardList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "boardPaging";
    }

}
