package com.cse.coari.service.graduates;

import com.cse.coari.domain.graduate.Graduates;
import com.cse.coari.domain.graduate.GraduatesRepository;
import com.cse.coari.web.dto.graduates.GraduatesListResponseDto;
import com.cse.coari.web.dto.graduates.GraduatesResponseDto;
import com.cse.coari.web.dto.graduates.GraduatesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class GraduatesService {
    private static final String FILE_SERVER_PATH = "http://co-ari.o-r.kr:8080/fileData";
    private final GraduatesRepository graduatesRepository;

    @Transactional
    public Long save(GraduatesSaveRequestDto requestDto, MultipartFile file) throws IOException {
        // 졸업생 명예의 전당 등록 & 파일 전송
        String fileName = file.getOriginalFilename();
        requestDto.setFileName(fileName);
        requestDto.setFileType(file.getContentType());
        requestDto.setFileURL(FILE_SERVER_PATH + fileName);

        if(!file.getOriginalFilename().isEmpty()) {
            file.transferTo(new File(FILE_SERVER_PATH, file.getOriginalFilename()));
        }

        return graduatesRepository.save(requestDto.toEntity()).getGraduate_id();
    }

    public GraduatesResponseDto findById(Long graduate_id) { // 해당 졸업생 명예의 전당 검색
        Graduates entity = graduatesRepository.findById(graduate_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 졸업생 게시글이 없습니다. id=" + graduate_id));

        return new GraduatesResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<GraduatesListResponseDto> findAll() { // 졸업생 명예의 전당 전체 검색
        return graduatesRepository.findAll().stream()
                .map(GraduatesListResponseDto::new)
                .collect(Collectors.toList());
    }
}
