package com.cse.coari.web.dto.news;

import com.cse.coari.domain.news.News;
import lombok.Getter;

@Getter
public class NewsListResponseDto {
    private Long news_id;
    private String title;
    private String author;
    private String date;
    private String news_thumbnail;
    private String url;

    public NewsListResponseDto(News entity) {
        this.news_id = entity.getNews_id();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.date = entity.getDate();
        this.news_thumbnail = entity.getNews_thumbnail();
        this.url = entity.getUrl();

    }
}
