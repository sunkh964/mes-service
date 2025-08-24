package com.example.mes_service.dto;

import com.example.mes_service.Entity.QualityControl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QualityControlResponseDto {
    private Integer qcId;
    private Integer workOrderId;
    private Integer inspectorId;
    private LocalDateTime inspectionDate;
    private String result;
    private String notes;

    public QualityControlResponseDto(QualityControl qc) {
        this.qcId = qc.getQcId();
        this.workOrderId = qc.getWorkOrder().getWorkOrderId();
        this.inspectorId = qc.getInspectorId();
        this.inspectionDate = qc.getInspectionDate();
        this.result = qc.getResult();
        this.notes = qc.getNotes();
    }
}