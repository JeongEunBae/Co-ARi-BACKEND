package com.cse.coari.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id; // PRIMARY KEY 지정

    private String kakao_token;

    private String google_token;

    @Builder
    private Users(String kakao_token, String google_token) {
        this.kakao_token = kakao_token;
        this.google_token = google_token;
    }

}
