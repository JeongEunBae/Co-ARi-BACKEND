package com.cse.coari.web.dto.alarms;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlarmsUpdateRequestDto {
    private String read_mark;
    private String visibility;

    @Builder
    public AlarmsUpdateRequestDto(String read_mark, String visibility) {
        this.read_mark = read_mark;
        this.visibility = visibility;
    }
}
