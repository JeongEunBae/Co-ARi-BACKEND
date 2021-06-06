package com.cse.coari.web.controller;

import com.cse.coari.service.alarms.AlarmsService;
import com.cse.coari.web.dto.alarms.AlarmsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/room")
    public String room() {
        return "room";
    }

    @GetMapping("/alarm")
    public String alarm() {
        return "alarm";
    }

    @GetMapping("/new_admin")
    public String new_admin() {
        return "new_admin";
    }

}
