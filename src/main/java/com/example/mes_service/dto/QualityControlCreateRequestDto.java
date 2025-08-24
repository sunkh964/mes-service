package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QualityControlCreateRequestDto {
    private Integer workOrderId;
    private Integer inspectorId;
    private String result;
    private String notes;
}
