package com.cse.coari.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class FcmUtil {
    public void sendFCM(String title, String content) {
        try{
            // json 파일 경로 설정
            FileInputStream serviceAccount =
                    new FileInputStream("classpath:keystore/coari-service-account.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://coari-309820-default-rtdb.firebaseio.com")
                    .build();

            // Firebase 처음 호출시에만 initializing 처리
            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

            String registrationToken = "oIRymNFRByg6skQg2FTQf2TipPW2";

            // Message 작성
            Message message = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                    .setTtl(3600 * 1000)
                    .setPriority(AndroidConfig.Priority.NORMAL)
                    .setNotification(AndroidNotification.builder()
                            .setTitle(title)
                            .setBody(content)
                            .setColor("#f45342")
                            .build())
                        .build())
                    .setToken(registrationToken)
                    .build();

            // 메시지를 FirebaseMessageing에 보내기
            String response = FirebaseMessaging.getInstance().send(message);

            System.out.println("Successfully sent message: " + response);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
