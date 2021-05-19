package com.cse.coari.web.dto.anchors;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnchorsUpdateRequestDto {
    private String roomName;
    private String roomContent;
    private String roomImage;
    private String roomVideo;
    private String department;
    private String buildingName;
    private String floor;

    @Builder
    public AnchorsUpdateRequestDto(String roomName, String roomContent, String roomImage, String roomVideo,
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
