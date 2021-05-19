package com.cse.coari.web.dto.anchors;

import com.cse.coari.domain.anchors.Anchors;
import lombok.Getter;


@Getter
public class AnchorsResponseDto {
    private Long anchor_id;
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
    private String startPoint;
    private String planeWidthSize;
    private String planeHeightSize;

    public AnchorsResponseDto(Anchors entity) {
        this.anchor_id = entity.getAnchor_id();
        this.roomNumber = entity.getRoomNumber();
        this.roomName = entity.getRoomName();
        this.roomContent = entity.getRoomContent();
        this.roomImage = entity.getRoomImage();
        this.roomVideo = entity.getRoomVideo();
        this.pose_x = entity.getPose_x();
        this.pose_y = entity.getPose_y();
        this.pose_z = entity.getPose_z();
        this.department = entity.getDepartment();
        this.buildingName = entity.getBuildingName();
        this.floor = entity.getFloor();
        this.startPoint = entity.getStartPoint();
        this.planeWidthSize = entity.getPlaneWidthSize();
        this.planeHeightSize = entity.getPlaneHeightSize();
    }
}
