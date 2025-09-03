package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentCreateRequestDto {
    private Integer blockId;
    private String destination;
    private String status;
    private String notes;
}