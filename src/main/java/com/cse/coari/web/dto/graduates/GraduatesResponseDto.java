package com.cse.coari.web.dto.graduates;

import com.cse.coari.domain.graduate.Graduates;
import lombok.Getter;

@Getter
public class GraduatesResponseDto {
    private Long graduate_id;
    private String name;
    private String interview_content;
    private String image;
    private String companyInfo;
    private String work;

    public GraduatesResponseDto(Graduates entity) {
        this.graduate_id = entity.getGraduate_id();
        this.name = entity.getImage();
        this.interview_content = entity.getInterview_content();
        this.image = entity.getImage();
        this.companyInfo = entity.getCompanyInfo();
        this.work = entity.getWork();
    }
}
