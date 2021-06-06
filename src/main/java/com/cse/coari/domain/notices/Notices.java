package com.cse.coari.domain.notices;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Component
public class Notices {

    // Primary KEY 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notice_id;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "author")
    private String author;

    //null 여부 설정
    @Column(nullable = false, name = "date")
    private String date;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(nullable = false, name = "url")
    private String url;

    @Builder
    public Notices(String title, String author, String date, String url) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.url = url;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + date + ", " + url;
    }
}
