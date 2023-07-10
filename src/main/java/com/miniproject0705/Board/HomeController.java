package com.miniproject0705.Board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링에게 이 클래스가 Controller라고 알림
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }
}
