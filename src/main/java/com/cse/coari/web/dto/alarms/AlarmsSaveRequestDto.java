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
    private String read_mark;
    private String visibility;

    @Builder
    public AlarmsSaveRequestDto(String title, String content, String author, String send_time, String read_mark, String visibility) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.send_time = send_time;
        this.read_mark = read_mark;
        this.visibility = visibility;
    }

    public Alarms toEntity() {
        return Alarms.builder()
                .title(title)
                .content(content)
                .author(author)
                .send_time(send_time)
                .read_mark(read_mark)
                .visibility(visibility)
                .build();
    }
}
