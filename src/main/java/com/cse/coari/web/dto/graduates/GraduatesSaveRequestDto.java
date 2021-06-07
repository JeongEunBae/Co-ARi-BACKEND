package com.cse.coari.web.dto.graduates;

import com.cse.coari.domain.graduate.Graduates;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@NoArgsConstructor
public class GraduatesSaveRequestDto {
    private String name;
    private String interview_content;
    private String fileURL;
    private String fileType;
    private String fileName;
    private String companyInfo;
    private String company;
    private String work;

    @Builder
    public GraduatesSaveRequestDto(String name, String interview_content, String companyInfo, String company, String work) {
        this.name = name;
        this.interview_content = interview_content;
        this.companyInfo = companyInfo;
        this.company = company;
        this.work = work;
    }

    public Graduates toEntity() {
        return Graduates.builder()
                .name(name)
                .interview_content(interview_content)
                .fileURL(fileURL)
                .fileType(fileType)
                .fileName(fileName)
                .companyInfo(companyInfo)
                .company(company)
                .work(work)
                .build();
    }
}
