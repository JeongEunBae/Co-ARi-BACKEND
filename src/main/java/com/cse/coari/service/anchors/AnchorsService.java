package com.cse.coari.service.anchors;

import com.cse.coari.domain.anchors.Anchors;
import com.cse.coari.domain.anchors.AnchorsRepository;
import com.cse.coari.web.dto.anchors.AnchorsResponseDto;
import com.cse.coari.web.dto.anchors.AnchorsSaveRequestDto;
import com.cse.coari.web.dto.anchors.AnchorsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnchorsService {
    private final AnchorsRepository anchorsRepository;

    @Transactional
    public Long save(AnchorsSaveRequestDto requestDto) {
        // 앵커 등록
        return anchorsRepository.save(requestDto.toEntity()).getAnchor_id();
    }

    @Transactional
    public Long update(Long anchor_id, AnchorsUpdateRequestDto requestDto) {
        // 해당 앵커 정보 수정
        Anchors anchors = anchorsRepository.findById(anchor_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 앵커가 없습니다. id=" +anchor_id));

        anchors.update(requestDto.getRoomName(), requestDto.getRoomContent(), requestDto.getRoomImage(), requestDto.getRoomVideo(),
                requestDto.getDepartment(), requestDto.getBuildingName(), requestDto.getFloor());
        return anchor_id;
    }

    public AnchorsResponseDto findById(Long anchor_id) { // 해당 앵커 검색
        Anchors entity = anchorsRepository.findById(anchor_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 앵커가 없습니다. id=" + anchor_id));

        return new AnchorsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<AnchorsResponseDto> findAll() { // 앵커 전체 검색
        return anchorsRepository.findAll().stream()
                .map(AnchorsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long anchor_id) { // 해당 앵커 삭제
        Anchors anchors = anchorsRepository.findById(anchor_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 앵커가 없습니다. id=" + anchor_id));

        anchorsRepository.delete(anchors);
    }
}
