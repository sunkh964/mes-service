// File: src/main/java/com/example/mes_service/dto/EquipmentResponseDto.java
package com.example.mes_service.dto;

import com.example.mes_service.Entity.Equipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentResponseDto {

    private String equipmentId;
    private String equipmentName;
    private String modelName;
    private String status;
    private LocalDate lastInspectionDate;
    private String workCenterId;

    public EquipmentResponseDto(Equipment equipment) {
        this.equipmentId = equipment.getEquipmentId();
        this.equipmentName = equipment.getEquipmentName();
        this.modelName = equipment.getModelName();
        this.status = equipment.getStatus();
        this.lastInspectionDate = equipment.getLastInspectionDate();
        if (equipment.getWorkCenter() != null) {
            this.workCenterId = equipment.getWorkCenter().getWorkCenterId();
        }
    }
}