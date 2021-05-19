package com.cse.coari.web.dto.news;

import com.cse.coari.domain.news.News;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String date;
    private String url;
    private String news_thumbnail;

    @Builder
    public NewsSaveRequestDto(String title, String content, String author, String date, String url, String news_thumbnail) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.url = url;
        this.news_thumbnail = news_thumbnail;
    }

    public News toEntity() {
        return News.builder()
                .title(title)
                .content(content)
                .author(author)
                .date(date)
                .url(url)
                .news_thumbnail(news_thumbnail)
                .build();
    }
}
