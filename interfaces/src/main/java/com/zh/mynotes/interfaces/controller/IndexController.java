package com.zh.mynotes.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author iccry.zeng
 * @Description
 * @Date Create in 2022/09/04 1:50
 */
@RestController
@RequestMapping("index")
public class IndexController {


    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
