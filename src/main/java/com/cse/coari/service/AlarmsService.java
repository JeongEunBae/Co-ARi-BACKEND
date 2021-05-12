package com.cse.coari.service;

import com.cse.coari.domain.alarms.Alarms;
import com.cse.coari.domain.alarms.AlarmsRepository;
import com.cse.coari.web.dto.alarms.AlarmsResponseDto;
import com.cse.coari.web.dto.alarms.AlarmsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AlarmsService {
    private final AlarmsRepository alarmsRepository;

    @Transactional
    public Long save(AlarmsSaveRequestDto requestDto) {
        // 알림 등록
        return alarmsRepository.save(requestDto.toEntity()).getAlarm_id();
    }

    public AlarmsResponseDto findById(Long id) { // 해당 알림 검색
        Alarms entity = alarmsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 알림이 없습니다. id=" + id));

        return new AlarmsResponseDto(entity);
    }
}
