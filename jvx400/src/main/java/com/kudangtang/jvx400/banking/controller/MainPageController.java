package com.kudangtang.jvx400.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping(value = "/")
    public String mainpageload() {
        return "index";
    }
}
