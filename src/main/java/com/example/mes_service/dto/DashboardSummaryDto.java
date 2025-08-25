package com.example.mes_service.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class DashboardSummaryDto {
    private long totalWorkOrders;
    private long inProgressWorkOrders;
    private long completedWorkOrders;
    private Map<String, Long> equipmentStatusCounts;
    private List<WorkCenterProductionDto> workCenterProductions;

    @Getter
    @Builder
    public static class WorkCenterProductionDto {
        private String workCenterName;
        private int totalPlanned;
        private int totalProduced;
    }
}