package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkCenterCreateRequestDto {
    private String workCenterId;
    private String workCenterName;
    private String location;
    private boolean isActive = true; // 생성 시 기본값을 true로 설정
}