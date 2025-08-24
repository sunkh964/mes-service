package com.example.mes_service.dto;

import com.example.mes_service.Entity.WorkOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    // 연관된 객체의 ID
    private String processId;
    private Integer processPlanId;
    private Integer blockId;
    private String workCenterId;

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

        this.processId = workOrder.getProcess().getProcessId();
        this.processPlanId = workOrder.getProcessPlan().getProcessPlanId();
        this.blockId = workOrder.getBlock().getBlockId();
        this.workCenterId = workOrder.getWorkCenter().getWorkCenterId();
    }
}