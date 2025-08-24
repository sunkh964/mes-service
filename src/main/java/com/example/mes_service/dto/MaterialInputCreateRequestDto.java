package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialInputCreateRequestDto {
    private Integer quantity;
    private String warehouseName;
}
