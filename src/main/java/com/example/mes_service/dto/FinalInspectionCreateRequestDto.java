package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinalInspectionCreateRequestDto {
    private Integer workOrderId;
    private String inspectorId;
    private String result;
    private String notes;
}