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

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final ProcessRepository processRepository;
    private final ProcessPlanRepository processPlanRepository;
    private final BlockRepository blockRepository;
    private final WorkCenterRepository workCenterRepository;

    public List<WorkOrderResponseDto> findAllWorkOrders() {
        return workOrderRepository.findAll().stream()
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
}