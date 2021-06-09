package com.cse.coari.web.controller.graduates;


import com.cse.coari.service.graduates.GraduatesService;
import com.cse.coari.web.dto.graduates.GraduatesListResponseDto;
import com.cse.coari.web.dto.graduates.GraduatesResponseDto;
import com.cse.coari.web.dto.graduates.GraduatesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/graduates")
public class GraduatesApiController {
    private final GraduatesService graduatesService;

    @PostMapping
    public Long save(@RequestBody GraduatesSaveRequestDto requestDto)
    {
        return graduatesService.save(requestDto);
    }

    @GetMapping(value = "/{graduate_id}")
    public GraduatesResponseDto findById(@PathVariable Long graduate_id) {
        return graduatesService.findById(graduate_id);
    }

    @GetMapping(value = "/search")
    public List<GraduatesListResponseDto> findAll() {
        return graduatesService.findAll();
    }

}
