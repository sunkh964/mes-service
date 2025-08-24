package com.example.mes_service.dto;

import com.example.mes_service.Entity.WorkCenter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkCenterResponseDto {
    private String workCenterId;
    private String workCenterName;
    private String location;
    private boolean isActive;

    public WorkCenterResponseDto(WorkCenter workCenter) {
        this.workCenterId = workCenter.getWorkCenterId();
        this.workCenterName = workCenter.getWorkCenterName();
        this.location = workCenter.getLocation();
        this.isActive = workCenter.isActive();
    }
}