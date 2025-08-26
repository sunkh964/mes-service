package com.example.mes_service.Service;

import com.example.mes_service.Entity.Equipment;
import com.example.mes_service.Repository.EquipmentRepository;
import com.example.mes_service.Repository.WorkOrderRepository;
import com.example.mes_service.dto.DashboardSummaryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DashboardService {

    private final WorkOrderRepository workOrderRepository;
    private final EquipmentRepository equipmentRepository;

    public DashboardSummaryDto getDashboardSummary() {
        // 작업지시 현황 집계
        long totalWorkOrders = workOrderRepository.count();
        long inProgressWorkOrders = workOrderRepository.countByCurrentStatus("in_progress");
        long completedWorkOrders = workOrderRepository.countByCurrentStatus("completed");

        // 설비 상태별 집계
        Map<String, Long> equipmentStatusCounts = equipmentRepository.findAll().stream()
                .collect(Collectors.groupingBy(Equipment::getStatus, Collectors.counting()));

        // 작업장별 생산량 집계
        List<DashboardSummaryDto.WorkCenterProductionDto> workCenterProductions = workOrderRepository.findAll().stream()
                .collect(Collectors.groupingBy(wo -> wo.getWorkCenter().getWorkCenterName()))
                .entrySet().stream()
                .map(entry -> DashboardSummaryDto.WorkCenterProductionDto.builder()
                        .workCenterName(entry.getKey())
                        .totalPlanned(entry.getValue().stream().mapToInt(wo -> wo.getQuantityToProduce()).sum())
                        .totalProduced(entry.getValue().stream().mapToInt(wo -> wo.getQuantityProduced()).sum())
                        .build())
                .collect(Collectors.toList());

        return DashboardSummaryDto.builder()
                .totalWorkOrders(totalWorkOrders)
                .inProgressWorkOrders(inProgressWorkOrders)
                .completedWorkOrders(completedWorkOrders)
                .equipmentStatusCounts(equipmentStatusCounts)
                .workCenterProductions(workCenterProductions)
                .build();
    }
}