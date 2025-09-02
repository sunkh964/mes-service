package com.example.mes_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty; // import 추가
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkCenterCreateRequestDto {
    private String workCenterId;
    private String workCenterName;
    private String location;
    @JsonProperty("isActive")
    private boolean isActive = true; // 생성 시 기본값을 true로 설정
}