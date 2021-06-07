package com.cse.coari.web.dto.graduates;

import com.cse.coari.domain.graduate.Graduates;
import lombok.Getter;

@Getter
public class GraduatesResponseDto {
    private Long graduate_id;
    private String name;
    private String interview_content;
    private String fileURL;
    private String fileType;
    private String fileName;
    private String companyInfo;
    private String company;
    private String work;

    public GraduatesResponseDto(Graduates entity) {
        this.graduate_id = entity.getGraduate_id();
        this.name = entity.getName();
        this.interview_content = entity.getInterview_content();
        this.fileURL = entity.getFileURL();
        this.fileName = entity.getFileName();
        this.fileType = entity.getFileType();
        this.companyInfo = entity.getCompanyInfo();
        this.company = entity.getCompany();
        this.work = entity.getWork();
    }
}
