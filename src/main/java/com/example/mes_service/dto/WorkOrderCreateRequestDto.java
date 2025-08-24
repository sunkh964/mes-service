package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkOrderCreateRequestDto {
    private String processId;
    private Integer processPlanId;
    private Integer blockId;
    private String workCenterId;
    private String instruction;
    private Integer quantityToProduce;
    private LocalDateTime plannedStartDate;
    private LocalDateTime plannedEndDate;
}