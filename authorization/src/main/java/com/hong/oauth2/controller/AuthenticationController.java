package com.hong.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by caihongwei on 2019/5/24 10:46.
 */
@Controller
public class AuthenticationController {
    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}
