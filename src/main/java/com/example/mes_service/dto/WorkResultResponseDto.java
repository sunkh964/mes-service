package com.example.mes_service.dto;

import com.example.mes_service.Entity.WorkResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class WorkResultResponseDto {
    private Integer resultId;
    private Integer workOrderId;
    private Integer completedQuantity;
    private Integer defectiveQuantity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime inputTime;

    public WorkResultResponseDto(WorkResult workResult) {
        this.resultId = workResult.getResultId();
        this.workOrderId = workResult.getWorkOrder().getWorkOrderId();
        this.completedQuantity = workResult.getCompletedQuantity();
        this.defectiveQuantity = workResult.getDefectiveQuantity();
        this.startTime = workResult.getStartTime();
        this.endTime = workResult.getEndTime();
        this.inputTime = workResult.getInputTime();
    }
}
