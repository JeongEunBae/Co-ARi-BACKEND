package com.cse.coari.web.dto.users;

import com.cse.coari.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String kakao_token;
    private String google_token;

    @Builder
    public UsersSaveRequestDto(String kakao_token, String google_token) {
        this.kakao_token = kakao_token;
        this.google_token = google_token;
    }

    public Users toEntity() {
        return Users.builder()
                .kakao_token(kakao_token)
                .google_token(google_token)
                .build();
    }
}
