package com.example.mes_service.dto;

import com.example.mes_service.Entity.MaterialInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MaterialInputResponseDto {
    private Integer inputId;
    private Integer quantity;
    private LocalDateTime inputDate;
    private String warehouseName;

    public MaterialInputResponseDto(MaterialInput materialInput) {
        this.inputId = materialInput.getInputId();
        this.quantity = materialInput.getQuantity();
        this.inputDate = materialInput.getInputDate();
        this.warehouseName = materialInput.getWarehouseName();
    }
}
