package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefectReportCreateRequestDto {
    private Integer qcId;
    private Integer quantity;
}
