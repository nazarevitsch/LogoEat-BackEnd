package com.bida.logoeat.logoeat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index1() {
        return "Hello";
    }

    @GetMapping("/")
    public String index2() {
        return "Hello";
    }
}
