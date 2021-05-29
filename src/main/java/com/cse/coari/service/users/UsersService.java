package com.cse.coari.service.users;

import com.cse.coari.domain.users.UsersRepository;
import com.cse.coari.web.dto.users.UsersListResponseDto;
import com.cse.coari.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        // 사용자 등록
        return usersRepository.save(requestDto.toEntity()).getUser_id();
    }

    @Transactional
    public List<UsersListResponseDto> findByUserID(String userID) { // 사용자 전체 검색
        return usersRepository.findByUserID(userID).stream()
                .map(UsersListResponseDto::new)
                .collect(Collectors.toList());
    }
}
