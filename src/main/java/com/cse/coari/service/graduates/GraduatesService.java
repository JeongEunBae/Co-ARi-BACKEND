package com.cse.coari.service.graduates;

import com.cse.coari.domain.graduate.Graduates;
import com.cse.coari.domain.graduate.GraduatesRepository;
import com.cse.coari.web.dto.graduates.GraduatesListResponseDto;
import com.cse.coari.web.dto.graduates.GraduatesResponseDto;
import com.cse.coari.web.dto.graduates.GraduatesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GraduatesService {
    private final GraduatesRepository graduatesRepository;

    @Transactional
    public Long save(GraduatesSaveRequestDto requestDto) {
        // 졸업생 명예의 전당 등록
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
