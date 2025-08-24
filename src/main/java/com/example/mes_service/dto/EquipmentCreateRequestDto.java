// File: src/main/java/com/example/mes_service/dto/EquipmentCreateRequestDto.java
package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EquipmentCreateRequestDto {
    private String equipmentId;
    private String equipmentName;
    private String modelName;
    private String status;
    private LocalDate lastInspectionDate;
    private String workCenterId;
}
