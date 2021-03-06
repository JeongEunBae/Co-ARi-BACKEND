package com.cse.coari.web.dto.notices;

import com.cse.coari.domain.notices.Notices;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticesSaveRequestDto {
    private String title;
    private String author;
    private String date;
    private String url;

    @Builder
    public NoticesSaveRequestDto(String title, String author, String date, String url) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.url = url;
    }

    public Notices toEntity() {
        return Notices.builder()
                .title(title)
                .author(author)
                .date(date)
                .url(url)
                .build();
    }
}
