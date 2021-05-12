package com.cse.coari.web.controller;

import com.cse.coari.service.AlarmsService;
import com.cse.coari.web.dto.alarms.AlarmsResponseDto;
import com.cse.coari.web.dto.alarms.AlarmsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/alarm")
public class AlarmsApiController {
    private final AlarmsService alarmsService;

    @PostMapping
    public Long save(@RequestBody AlarmsSaveRequestDto requestDto) {
        return alarmsService.save(requestDto);
    }

    @GetMapping(value = "/{alarm_id}")
    public AlarmsResponseDto findById(@PathVariable Long alarm_id) {
        return alarmsService.findById(alarm_id);
    }
}
