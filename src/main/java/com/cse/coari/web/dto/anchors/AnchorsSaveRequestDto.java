package com.cse.coari.web.dto.anchors;

import com.cse.coari.domain.anchors.Anchors;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class AnchorsSaveRequestDto {
    private String roomNumber;
    private String roomName;
    private String roomContent;
    private String roomVideo;
    private String pose;
    private String department;
    private String buildingName;
    private String floor;

    @Builder
    public AnchorsSaveRequestDto(String roomNumber, String roomName, String roomContent, String roomVideo,
    String pose, String department, String buildingName, String floor) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.roomContent = roomContent;
        this.roomVideo = roomVideo;
        this.pose = pose;
        this.department = department;
        this.buildingName = buildingName;
        this.floor = floor;
    }

    public Anchors toEntity() {
        return Anchors.builder()
                .roomNumber(roomNumber)
                .roomName(roomName)
                .roomContent(roomContent)
                .roomVideo(roomVideo)
                .pose(pose)
                .department(department)
                .buildingName(buildingName)
                .floor(floor)
                .build();
    }
}
