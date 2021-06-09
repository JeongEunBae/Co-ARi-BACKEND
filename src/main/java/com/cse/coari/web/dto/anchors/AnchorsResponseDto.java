package com.cse.coari.web.dto.anchors;

import com.cse.coari.domain.anchors.Anchors;
import lombok.Getter;


@Getter
public class AnchorsResponseDto {
    private Long anchor_id;
    private String roomNumber;
    private String roomName;
    private String roomContent;
    private String roomVideo;
    private String pose;
    private String department;
    private String buildingName;
    private String floor;

    public AnchorsResponseDto(Anchors entity) {
        this.anchor_id = entity.getAnchor_id();
        this.roomNumber = entity.getRoomNumber();
        this.roomName = entity.getRoomName();
        this.roomContent = entity.getRoomContent();
        this.roomVideo = entity.getRoomVideo();
        this.pose = entity.getPose();
        this.department = entity.getDepartment();
        this.buildingName = entity.getBuildingName();
        this.floor = entity.getFloor();
    }
}
