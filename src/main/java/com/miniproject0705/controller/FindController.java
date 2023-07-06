package com.miniproject0705.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FindController {
    @GetMapping("findId&pw")
    public String getFind(){
        return "findInfoPage";
    }
}
