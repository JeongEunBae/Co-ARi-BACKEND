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

    private final AlarmsService alarmsService;

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("alarms", alarmsService.findAllDesc());
        return "index";
    }

    @GetMapping("/alarms/save")
    public String alarmsSave() {
        return "alarms-save";
    }

    @GetMapping("/alarms/update/{alarm_id}")
    public String alarmsUpdate(@PathVariable Long alarm_id, Model model) {
        AlarmsResponseDto dto = alarmsService.findById(alarm_id);
        model.addAttribute("alarms", dto);

        return "alarms-update";
    }
}
