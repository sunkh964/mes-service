package com.example.mes_service.Service;

import com.example.mes_service.Entity.*;

import com.example.mes_service.Repository.*;
import com.example.mes_service.dto.WorkOrderCreateRequestDto;
import com.example.mes_service.dto.WorkOrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final ProcessRepository processRepository;
    private final ProcessPlanRepository processPlanRepository;
    private final BlockRepository blockRepository;
    private final WorkCenterRepository workCenterRepository;

    // ✨ findAllWorkOrders 메서드를 검색 조건을 받도록 수정
    public List<WorkOrderResponseDto> findAllWorkOrders(String status, String workCenterId) {
        // 검색 조건 값이 비어있으면 null로 바꿔서 전달 (JPQL에서 IS NULL로 처리하기 위함)
        String statusFilter = (status == null || status.isEmpty()) ? null : status;
        String wcIdFilter = (workCenterId == null || workCenterId.isEmpty()) ? null : workCenterId;

        return workOrderRepository.findByFilters(statusFilter, wcIdFilter).stream()
                .map(WorkOrderResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public WorkOrderResponseDto createWorkOrder(WorkOrderCreateRequestDto requestDto) {
        com.example.mes_service.Entity.Process process = processRepository.findById(requestDto.getProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid process Id:" + requestDto.getProcessId()));
        ProcessPlan processPlan = processPlanRepository.findById(requestDto.getProcessPlanId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid process plan Id:" + requestDto.getProcessPlanId()));
        Block block = blockRepository.findById(requestDto.getBlockId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid block Id:" + requestDto.getBlockId()));
        WorkCenter workCenter = workCenterRepository.findById(requestDto.getWorkCenterId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid work center Id:" + requestDto.getWorkCenterId()));

        WorkOrder workOrder = WorkOrder.builder()
                .process(process)
                .processPlan(processPlan)
                .block(block)
                .workCenter(workCenter)
                .instruction(requestDto.getInstruction())
                .quantityToProduce(requestDto.getQuantityToProduce())
                .plannedStartDate(requestDto.getPlannedStartDate())
                .plannedEndDate(requestDto.getPlannedEndDate())
                .build();

        WorkOrder savedWorkOrder = workOrderRepository.save(workOrder);
        return new WorkOrderResponseDto(savedWorkOrder);
    }

    // ✨ 작업지시 상태 변경 (새로 추가)
    @Transactional
    public WorkOrderResponseDto updateWorkOrderStatus(Integer workOrderId, String newStatus) {
        WorkOrder workOrder = workOrderRepository.findById(workOrderId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkOrder ID"));

        // 상태 변경과 함께 실제 시작/종료 시간도 기록
        if ("in_progress".equals(newStatus)) {
            workOrder.setActualStartDate(LocalDateTime.now());
        } else if ("completed".equals(newStatus)) {
            workOrder.setActualEndDate(LocalDateTime.now());
        }

        workOrder.setCurrentStatus(newStatus);

        return new WorkOrderResponseDto(workOrder);
    }
}