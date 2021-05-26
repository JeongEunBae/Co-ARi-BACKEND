package com.cse.coari.web.controller.anchors;

import com.cse.coari.service.anchors.AnchorsService;
import com.cse.coari.web.dto.anchors.AnchorsResponseDto;
import com.cse.coari.web.dto.anchors.AnchorsSaveRequestDto;
import com.cse.coari.web.dto.anchors.AnchorsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/anchors")
public class AnchorsApiController {
    private final AnchorsService anchorsService;

    @PostMapping
    public Long save(@RequestBody AnchorsSaveRequestDto requestDto) {
        return anchorsService.save(requestDto);
    }

    @GetMapping(value = "/{anchor_id}")
    public AnchorsResponseDto findById(@PathVariable Long anchor_id) {
        return anchorsService.findById(anchor_id);
    }

    @GetMapping(value = "/search")
    public List<AnchorsResponseDto> findAll() {
        return anchorsService.findAll();
    }

    @PutMapping(value = "/{anchor_id}")
    public Long update(@PathVariable Long anchor_id, @RequestBody AnchorsUpdateRequestDto requestDto) {
        return anchorsService.update(anchor_id, requestDto);
    }

    @DeleteMapping(value = "/{anchor_id}")
    public Long delete(@PathVariable Long anchor_id) {
        anchorsService.delete(anchor_id);
        return anchor_id;
    }
}
