package com.cse.coari.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class FcmUtil {
    public void sendFCM(String tokenId, String title, String content) {
        try{
            // json 파일 경로 설정
            FileInputStream refreshToken = new FileInputStream("C:\\Users\\byg09\\BACKEND_Co-ARi\\src\\main\\resources\\fcm\\coari-309820-firebase-adminsdk-wwddn-bf976e073a.json");

//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
//                    .setDatabaseUrl()

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
