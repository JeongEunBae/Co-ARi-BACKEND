package com.cse.coari.web.dto.users;

import com.cse.coari.domain.users.Users;
import lombok.Getter;

@Getter
public class UsersResponseDto {
    private Long user_id;
    private String id;
    private String password;
    private String kakao_token;
    private String google_token;

    public UsersResponseDto(Users entity) {
        this.user_id = entity.getUser_id();
        this.id = entity.getId();
        this.password = entity.getPassword();
        this.kakao_token = entity.getKakao_token();
        this.google_token = entity.getGoogle_token();
    }
}
