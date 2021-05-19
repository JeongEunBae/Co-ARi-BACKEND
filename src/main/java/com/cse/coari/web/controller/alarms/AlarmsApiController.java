package com.cse.coari.web.controller.alarms;

import com.cse.coari.service.alarms.AlarmsService;
import com.cse.coari.web.dto.alarms.AlarmsListResponseDto;
import com.cse.coari.web.dto.alarms.AlarmsResponseDto;
import com.cse.coari.web.dto.alarms.AlarmsSaveRequestDto;
import com.cse.coari.web.dto.alarms.AlarmsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/alarms")
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

    @GetMapping(value = "/search")
    public List<AlarmsListResponseDto> findAllDesc() {
        return alarmsService.findAllDesc();
    }

    @PutMapping(value = "/{alarm_id}")
    public Long update(@PathVariable Long alarm_id, @RequestBody AlarmsUpdateRequestDto requestDto) {
        return alarmsService.update(alarm_id, requestDto);
    }

    @DeleteMapping(value = "/{alarm_id}")
    public Long delete(@PathVariable Long alarm_id) {
        alarmsService.delete(alarm_id);
        return alarm_id;
    }
}
