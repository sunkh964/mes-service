package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialOutputCreateRequestDto {
    private Integer quantity;
    private String destination;
    private Integer workOrderId;
    private String warehouseName;
}
