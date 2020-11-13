package com.thecheck.manage.controller;
/*
 * @author brKim
 * @date 2020/10/27
 * @desc
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
