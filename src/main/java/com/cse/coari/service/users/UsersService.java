package com.cse.coari.service.users;

import com.cse.coari.domain.users.Users;
import com.cse.coari.domain.users.UsersRepository;
import com.cse.coari.web.dto.users.UsersResponseDto;
import com.cse.coari.web.dto.users.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto requestDto) {
        // 사용자 등록
        return usersRepository.save(requestDto.toEntity()).getUser_id();
    }

    public UsersResponseDto findById(Long user_id) { // 해당 사용자 검색
        Users entity = usersRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + user_id));

        return new UsersResponseDto(entity);
    }

    @Transactional
    public void delete(Long user_id) { // 해당 사용자 삭제
        Users users = usersRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + user_id));

        usersRepository.delete(users);
    }
}
