package com.cse.coari.web.dto.graduates;

import com.cse.coari.domain.graduate.Graduates;
import lombok.Getter;

@Getter
public class GraduatesListResponseDto {
    private Long graduate_id;
    private String name;
    private String fileURL;

    public GraduatesListResponseDto(Graduates entity) {
        this.graduate_id = entity.getGraduate_id();
        this.name = entity.getName();
        this.fileURL = entity.getFileURL();
    }
}
