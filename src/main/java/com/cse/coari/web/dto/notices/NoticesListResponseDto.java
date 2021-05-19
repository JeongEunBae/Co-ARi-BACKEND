package com.cse.coari.web.dto.notices;

import com.cse.coari.domain.notices.Notices;
import lombok.Getter;

@Getter
public class NoticesListResponseDto {
    private Long notice_id;
    private String title;
    private String content;
    private String author;
    private String date;

    public NoticesListResponseDto(Notices entity){
        this.notice_id = entity.getNotice_id();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.date = entity.getDate();
    }
}
