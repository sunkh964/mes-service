package com.example.mes_service.dto;

import com.example.mes_service.Entity.MaterialOutput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MaterialOutputResponseDto {
    private Integer outputId;
    private Integer quantity;
    private String destination;
    private LocalDateTime outputDate;
    private Integer workOrderId;
    private String warehouseName;

    public MaterialOutputResponseDto(MaterialOutput materialOutput) {
        this.outputId = materialOutput.getOutputId();
        this.quantity = materialOutput.getQuantity();
        this.destination = materialOutput.getDestination();
        this.outputDate = materialOutput.getOutputDate();
        this.workOrderId = materialOutput.getWorkOrder().getWorkOrderId();
        this.warehouseName = materialOutput.getWarehouseName();
    }
}