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
//    private String fileType;
//    private String fileName;
    private String companyInfo;
    private String company;
    private String work;
    private String fileURL;

    @Builder
    public GraduatesSaveRequestDto(String name, String interview_content, String companyInfo, String company, String work, String fileURL) {
        this.name = name;
        this.interview_content = interview_content;
        this.companyInfo = companyInfo;
        this.company = company;
        this.work = work;
        this.fileURL = fileURL;
    }

    public Graduates toEntity() {
        return Graduates.builder()
                .name(name)
                .interview_content(interview_content)
                .companyInfo(companyInfo)
                .company(company)
                .work(work)
                .fileURL(fileURL)
                .build();

//                .fileType(fileType)
//                .fileName(fileName)

    }
}
