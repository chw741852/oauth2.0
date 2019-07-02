package com.hong.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caihongwei on 2019/3/18 15:43.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @GetMapping("")
    public Authentication user(Authentication authentication) {
        LOGGER.info("user {}", authentication);
        return authentication;
    }
}
