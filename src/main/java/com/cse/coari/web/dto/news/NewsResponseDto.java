package com.cse.coari.web.dto.news;

import com.cse.coari.domain.news.News;
import lombok.Getter;

@Getter
public class NewsResponseDto {
    private Long news_id;
    private String title;
    private String content;
    private String author;
    private String date;
    private String url;

    public NewsResponseDto(News entity) {
        this.news_id = entity.getNews_id();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.date = entity.getDate();
        this.url = entity.getUrl();
    }
}
