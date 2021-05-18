package com.cse.coari.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/alarms/save")
    public String alarmsSave() {
        return "alarms-save";
    }
}
