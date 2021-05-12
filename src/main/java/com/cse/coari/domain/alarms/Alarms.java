package com.cse.coari.domain.alarms;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Alarms {

    // Primary KEY 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarm_id;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(length = 500, nullable = false)
    private String title;

    // 데이터 형식 변경, null 여부 설정
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    // 데이터 형식 변경, null 여부 설정
    @Column(columnDefinition = "DATETIME", nullable = false)
    private String send_time;

    @Column(columnDefinition = "BOOL")
    private boolean is_read;

    @Column(columnDefinition = "BOOL")
    private boolean visibility;


    @Builder
    public Alarms(String title, String content, String author, String send_time, boolean is_read, boolean visibility) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.send_time = send_time;
        this.is_read = is_read;
        this.visibility = visibility;
    }
}
