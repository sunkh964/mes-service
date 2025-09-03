package com.example.mes_service.dto;

import com.example.mes_service.Entity.FinalInspection;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class FinalInspectionResponseDto {
    private final Integer inspectionId;
    private final Integer workOrderId;
    private final String inspectorId;
    private final String inspectorName;
    private final LocalDateTime inspectionDate;
    private final String result;
    private final String notes;

    public FinalInspectionResponseDto(FinalInspection inspection) {
        this.inspectionId = inspection.getInspectionId();
        this.workOrderId = inspection.getWorkOrder().getWorkOrderId();
        this.inspectionDate = inspection.getInspectionDate();
        this.result = inspection.getResult();
        this.notes = inspection.getNotes();

        if (inspection.getInspector() != null) {
            this.inspectorId = inspection.getInspector().getWorkerId();
            this.inspectorName = inspection.getInspector().getWorkerName();
        } else {
            this.inspectorId = null;
            this.inspectorName = null;
        }
    }
}