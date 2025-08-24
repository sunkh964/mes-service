package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProcessPlanCreateRequestDto {
    private Integer blockId;
    private String processId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer expectedWorkload;
}