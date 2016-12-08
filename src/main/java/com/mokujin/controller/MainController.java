package com.mokujin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Danil on 08.12.16.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String home() {
        return "employee";
    }

}
