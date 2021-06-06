package com.cse.coari.web.controller.news;

import com.cse.coari.service.news.NewsService;
import com.cse.coari.web.dto.news.NewsListResponseDto;
import com.cse.coari.web.dto.news.NewsResponseDto;
import com.cse.coari.web.dto.news.NewsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/news")
public class NewsApiController {
    private final NewsService newsService;

    @PostMapping
    public Long save(@RequestBody NewsSaveRequestDto requestDto) {
        return newsService.save(requestDto);
    }

    @GetMapping(value = "/{news_id}")
    public NewsResponseDto findById(@PathVariable Long news_id) {
        return newsService.findById(news_id);
    }

    @GetMapping(value = "/search")
    public List<NewsListResponseDto> findAll() {
        return newsService.findAll();
    }

    @GetMapping(value = "/crawler")
    public void newsCrawler() throws IOException { // 크롤링해서 가져오기
        newsService.newsCrawler();
    }
}
