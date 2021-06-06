package com.cse.coari.web.dto.notices;

import com.cse.coari.domain.notices.Notices;
import lombok.Getter;

@Getter
public class NoticesResponseDto {
    private Long notice_id;
    private String title;
    private String author;
    private String date;
    private String url;

    public NoticesResponseDto(Notices entity){
        this.notice_id = entity.getNotice_id();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.date = entity.getDate();
        this.url = entity.getUrl();
    }
}
