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

    // ✨ 작업자 정보를 보여줄 필드 추가
    private String workerId;
    private String workerName;

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

        // ✨ Worker 정보가 있을 경우에만 ID와 이름을 매핑
        if (workOrder.getWorker() != null) {
            this.workerId = workOrder.getWorker().getWorkerId();
            this.workerName = workOrder.getWorker().getWorkerName();
        }
    }
}