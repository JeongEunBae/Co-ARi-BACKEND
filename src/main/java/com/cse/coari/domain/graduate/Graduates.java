package com.cse.coari.domain.graduate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Graduates {
    // Primary KEY 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long graduate_id;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(length = 500, nullable = false)
    private String name;

    // 데이터 형식 변경
    @Column(columnDefinition = "TEXT")
    private String interview_content;

    private String fileURL;

    private String fileType;

    private String fileName;

    // 데이터 사이즈 조정
    @Column(columnDefinition = "TEXT")
    private String companyInfo;

    // 데이터 사이즈 조정
    @Column(columnDefinition = "TEXT")
    private String company;

    @Column(columnDefinition = "TEXT")
    private String work;

    @Builder
    public Graduates(String name, String interview_content, String companyInfo, String company, String work, String fileURL, String fileType, String fileName) {
        this.name = name;
        this.interview_content = interview_content;
        this.fileType = fileType;
        this.fileName = fileName;
        this.companyInfo = companyInfo;
        this.company = company;
        this.work = work;
        this.fileURL = fileURL;
    }
}


// 데이터 형식 변경
//    @Column(columnDefinition = "MEDIUMBLOB")
//    private MultipartFile file;

//@Column(columnDefinition = "TEXT")