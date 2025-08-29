package com.example.mes_service.dto;

import com.example.mes_service.Entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class WorkOrderResponseDto {

    private Integer workOrderId;
    private String instruction;
    private Integer quantityToProduce;
    private Integer quantityProduced;
    private String currentStatus;
    private LocalDateTime plannedStartDate;
    private LocalDateTime plannedEndDate;
    private LocalDateTime actualStartDate;
    private LocalDateTime actualEndDate;

    // 연관된 객체의 상세 정보
    private String processName;
    private String blockName;
    private String workCenterName;

    // 1:N 관계의 상세 리스트
    private List<WorkResultDto> workResults;
    private List<MaterialOutputDto> materialOutputs;
    private List<QualityControlDto> qualityControls;

    public WorkOrderResponseDto(WorkOrder workOrder) {
        this.workOrderId = workOrder.getWorkOrderId();
        this.instruction = workOrder.getInstruction();
        this.quantityToProduce = workOrder.getQuantityToProduce();
        this.quantityProduced = workOrder.getQuantityProduced();
        this.currentStatus = workOrder.getCurrentStatus();
        this.plannedStartDate = workOrder.getPlannedStartDate();
        this.plannedEndDate = workOrder.getPlannedEndDate();
        this.actualStartDate = workOrder.getActualStartDate();
        this.actualEndDate = workOrder.getActualEndDate();

        // 연관된 객체가 null일 경우를 대비하여 null 체크 추가
        if (workOrder.getProcess() != null) {
            this.processName = workOrder.getProcess().getProcessName();
        }
        if (workOrder.getBlock() != null) {
            this.blockName = workOrder.getBlock().getBlockName();
        }
        if (workOrder.getWorkCenter() != null) {
            this.workCenterName = workOrder.getWorkCenter().getWorkCenterName();
        }

        // Lazy Loading 예외를 방지하기 위해 Null 체크 후 매핑
        this.workResults = (workOrder.getWorkResults() != null) ?
                workOrder.getWorkResults().stream().map(WorkResultDto::new).collect(Collectors.toList()) : Collections.emptyList();

        this.materialOutputs = (workOrder.getMaterialOutputs() != null) ?
                workOrder.getMaterialOutputs().stream().map(MaterialOutputDto::new).collect(Collectors.toList()) : Collections.emptyList();

        this.qualityControls = (workOrder.getQualityControls() != null) ?
                workOrder.getQualityControls().stream().map(QualityControlDto::new).collect(Collectors.toList()) : Collections.emptyList();
    }

    // 내부에 사용할 간단한 DTO들
    @Getter
    private static class WorkResultDto {
        private final Integer completedQuantity;
        private final Integer defectiveQuantity;
        public WorkResultDto(WorkResult wr) {
            this.completedQuantity = wr.getCompletedQuantity();
            this.defectiveQuantity = wr.getDefectiveQuantity();
        }
    }

    @Getter
    private static class MaterialOutputDto {
        private final Integer quantity;
        private final String warehouseName;
        public MaterialOutputDto(MaterialOutput mo) {
            this.quantity = mo.getQuantity();
            this.warehouseName = mo.getWarehouseName();
        }
    }

    @Getter
    private static class QualityControlDto {
        private final String result;
        private final String notes;
        public QualityControlDto(QualityControl qc) {
            this.result = qc.getResult();
            this.notes = qc.getNotes();
        }
    }
}