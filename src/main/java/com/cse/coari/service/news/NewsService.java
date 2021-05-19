package com.cse.coari.service.news;

import com.cse.coari.domain.news.News;
import com.cse.coari.domain.news.NewsRepository;
import com.cse.coari.web.dto.news.NewsListResponseDto;
import com.cse.coari.web.dto.news.NewsResponseDto;
import com.cse.coari.web.dto.news.NewsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Transactional
    public Long save(NewsSaveRequestDto requestDto) {
        // 학과소식 등록
        return newsRepository.save(requestDto.toEntity()).getNews_id();
    }

    public NewsResponseDto findById(Long news_id) { // 해당 학과소식 검색
        News entity = newsRepository.findById(news_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 학과소식이 없습니다. id=" + news_id));

        return new NewsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<NewsListResponseDto> findAllDesc() { // 학과소식 전체 검색
        return newsRepository.findAllDesc().stream()
                .map(NewsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
