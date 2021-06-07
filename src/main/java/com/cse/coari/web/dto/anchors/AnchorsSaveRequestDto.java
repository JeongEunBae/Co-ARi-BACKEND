package com.cse.coari.web.dto.anchors;

import com.cse.coari.domain.anchors.Anchors;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnchorsSaveRequestDto {
    private String roomNumber;
    private String roomName;
    private String roomContent;
    private String roomImage;
    private String roomVideo;
    private String pose_x;
    private String pose_y;
    private String pose_z;
    private String department;
    private String buildingName;
    private String floor;

    @Builder
    public AnchorsSaveRequestDto(String roomNumber, String roomName, String roomContent, String roomImage, String roomVideo,
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

    public Anchors toEntity() {
        return Anchors.builder()
                .roomNumber(roomNumber)
                .roomName(roomName)
                .roomContent(roomContent)
                .roomImage(roomImage)
                .roomVideo(roomVideo)
                .pose_x(pose_x)
                .pose_y(pose_y)
                .pose_z(pose_z)
                .department(department)
                .buildingName(buildingName)
                .floor(floor)
                .build();
    }
}
