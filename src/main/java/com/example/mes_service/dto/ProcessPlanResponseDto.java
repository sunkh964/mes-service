package com.example.mes_service.dto;

import com.example.mes_service.Entity.ProcessPlan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProcessPlanResponseDto {
    private Integer processPlanId;
    private Integer blockId;
    private String processId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer expectedWorkload;

    public ProcessPlanResponseDto(ProcessPlan processPlan) {
        this.processPlanId = processPlan.getProcessPlanId();
        this.blockId = processPlan.getBlock().getBlockId();
        this.processId = processPlan.getProcess().getProcessId();
        this.startDate = processPlan.getStartDate();
        this.endDate = processPlan.getEndDate();
        this.expectedWorkload = processPlan.getExpectedWorkload();
    }
}