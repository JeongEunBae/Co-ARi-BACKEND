package com.cse.coari.domain.news;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class News {

    // Primary KEY 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long news_id;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(length = 500, nullable = false)
    private String title;

    // 데이터 형식 변경, null 여부 설정
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    // 데이터 형식 변경, null 여부 설정
    @Column(columnDefinition = "DATE", nullable = false)
    private String date;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(length = 700, nullable = false)
    private String url;

    // 데이터 형식 변경
    @Column(columnDefinition = "MEDIUMBLOB")
    private String news_thumbnail;

    @Builder
    public News(String title, String content, String author, String date, String url, String news_thumbnail) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.url = url;
        this.news_thumbnail = news_thumbnail;
    }
}
