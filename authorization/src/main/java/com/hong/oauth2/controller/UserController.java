package com.hong.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caihongwei on 2019/3/18 15:43.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String save() {

        return "success";
    }
}
