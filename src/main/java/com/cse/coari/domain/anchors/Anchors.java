package com.cse.coari.domain.anchors;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Component
public class Anchors {

    // Primary KEY 지정
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long anchor_id;

    // null 여부 설정
    @Column(nullable = false)
    private String roomNumber;

    // null 여부 설정
    @Column(nullable = false)
    private String roomName;

    // 데이터 형식 변경, null 여부 설정
    @Column(columnDefinition = "TEXT", nullable = false)
    private String roomContent;

    // 데이터 형식 변경
    @Column(columnDefinition = "MEDIUMBLOB")
    private String roomImage;

    private String roomVideo;

    // null 여부 설정
    @Column(nullable = false)
    private String pose_x;

    // null 여부 설정
    @Column(nullable = false)
    private String pose_y;

    // null 여부 설정
    @Column(nullable = false)
    private String pose_z;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(length = 500, nullable = false)
    private String department;

    // 데이터 사이즈 조정, null 여부 설정
    @Column(length = 500, nullable = false)
    private String buildingName;

    // null 여부 설정
    @Column(nullable = false)
    private String floor;

    @Builder
    public Anchors(String roomNumber, String roomName, String roomContent, String roomImage, String roomVideo,
                   String pose_x, String pose_y, String pose_z, String department, String buildingName, String floor) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.roomContent = roomContent;
        this.roomImage = roomImage;
        this.roomVideo = roomVideo;
        this.pose_x = pose_x;
        this.pose_y = pose_y;
        this.pose_z = pose_z;
        this.department = department;
        this.buildingName = buildingName;
        this.floor = floor;
    }

    public void update(String roomName, String roomContent, String roomImage, String roomVideo,
                       String department, String buildingName, String floor) {
        this.roomName = roomName;
        this.roomContent = roomContent;
        this.roomImage = roomImage;
        this.roomVideo = roomVideo;
        this.department = department;
        this.buildingName = buildingName;
        this.floor = floor;
    }
}
