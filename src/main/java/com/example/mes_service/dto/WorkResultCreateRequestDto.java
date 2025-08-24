package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkResultCreateRequestDto {
    private Integer workOrderId;
    private Integer completedQuantity;
    private Integer defectiveQuantity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}