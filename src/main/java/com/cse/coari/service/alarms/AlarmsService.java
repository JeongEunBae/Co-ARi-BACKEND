package com.cse.coari.service.alarms;

import com.cse.coari.domain.alarms.Alarms;
import com.cse.coari.domain.alarms.AlarmsRepository;
import com.cse.coari.web.dto.alarms.AlarmsListResponseDto;
import com.cse.coari.web.dto.alarms.AlarmsResponseDto;
import com.cse.coari.web.dto.alarms.AlarmsSaveRequestDto;
import com.cse.coari.web.dto.alarms.AlarmsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AlarmsService {
    private final AlarmsRepository alarmsRepository;

    @Transactional
    public Long save(AlarmsSaveRequestDto requestDto) {
        // 알림 등록
        return alarmsRepository.save(requestDto.toEntity()).getAlarm_id();
    }

    @Transactional
    public Long update(Long alarm_id, AlarmsUpdateRequestDto requestDto) {
        // 해당 알림 수정
        Alarms alarms = alarmsRepository.findById(alarm_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 알림이 없습니다. id=" +alarm_id));

        alarms.update(requestDto.getRead_mark(), requestDto.getVisibility());
        return alarm_id;
    }

    public AlarmsResponseDto findById(Long alarm_id) { // 해당 알림 검색
        Alarms entity = alarmsRepository.findById(alarm_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 알림이 없습니다. id=" + alarm_id));

        return new AlarmsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<AlarmsListResponseDto> findAllDesc() { // 알림 전체 검색
        return alarmsRepository.findAllDesc().stream()
                .map(AlarmsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long alarm_id) {
        Alarms alarms = alarmsRepository.findById(alarm_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 알림이 없습니다. id=" + alarm_id));

        alarmsRepository.delete(alarms);
    }
}
