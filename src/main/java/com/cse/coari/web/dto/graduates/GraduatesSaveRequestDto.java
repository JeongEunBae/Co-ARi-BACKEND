package com.cse.coari.web.dto.graduates;

import com.cse.coari.domain.graduate.Graduates;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GraduatesSaveRequestDto {
    private String name;
    private String interview_content;
    private String image;
    private String companyInfo;
    private String work;

    @Builder
    public GraduatesSaveRequestDto(String name, String interview_content, String image, String companyInfo, String work) {
        this.name = name;
        this.interview_content = interview_content;
        this.image = image;
        this.companyInfo = companyInfo;
        this.work = work;
    }

    public Graduates toEntity() {
        return Graduates.builder()
                .name(name)
                .interview_content(interview_content)
                .image(image)
                .companyInfo(companyInfo)
                .work(work)
                .build();
    }
}
