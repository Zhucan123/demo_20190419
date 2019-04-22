package com.zc.demo_20190419.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class HomeController {


    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
