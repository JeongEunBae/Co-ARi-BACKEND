package com.cse.coari.web.dto.alarms;

import com.cse.coari.domain.alarms.Alarms;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlarmsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String send_time;
    private boolean  is_read;
    private boolean visibility;

    @Builder
    public AlarmsSaveRequestDto(String title, String content, String author, String send_time, boolean is_read, boolean visibility) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.send_time = send_time;
        this.is_read = is_read;
        this.visibility = visibility;
    }

    public Alarms toEntity() {
        return Alarms.builder()
                .title(title)
                .content(content)
                .author(author)
                .send_time(send_time)
                .is_read(is_read)
                .visibility(visibility)
                .build();
    }
}
