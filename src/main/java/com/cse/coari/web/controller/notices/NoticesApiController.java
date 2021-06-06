package com.cse.coari.web.controller.notices;

import com.cse.coari.service.notices.NoticesService;
import com.cse.coari.web.dto.notices.NoticesListResponseDto;
import com.cse.coari.web.dto.notices.NoticesResponseDto;
import com.cse.coari.web.dto.notices.NoticesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/notices")
public class NoticesApiController {
    private final NoticesService noticesService;

    @PostMapping
    public Long save(@RequestBody NoticesSaveRequestDto requestDto) {
        return noticesService.save(requestDto);
    }

    @GetMapping(value = "/{notice_id}")
    public NoticesResponseDto findById(@PathVariable Long notice_id) {
        return noticesService.findById(notice_id);
    }

    @GetMapping(value = "/search")
    public List<NoticesListResponseDto> findAllDesc() throws IOException {
        return noticesService.findAllDesc();
    }

    @GetMapping(value = "/crawler")
    public void noticeCrawler() throws IOException { // 크롤링해서 가져오기
        noticesService.noticeCrawler();
    }


}
