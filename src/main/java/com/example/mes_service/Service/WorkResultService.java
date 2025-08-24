package com.example.mes_service.Service;

import com.example.mes_service.Entity.WorkOrder;
import com.example.mes_service.Entity.WorkResult;
import com.example.mes_service.Repository.WorkOrderRepository;
import com.example.mes_service.Repository.WorkResultRepository;
import com.example.mes_service.dto.WorkResultCreateRequestDto;
import com.example.mes_service.dto.WorkResultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkResultService {

    private final WorkResultRepository workResultRepository;
    private final WorkOrderRepository workOrderRepository;

    public List<WorkResultResponseDto> findAllWorkResults() {
        return workResultRepository.findAll().stream()
                .map(WorkResultResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public WorkResultResponseDto createWorkResult(WorkResultCreateRequestDto requestDto) {
        WorkOrder workOrder = workOrderRepository.findById(requestDto.getWorkOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkOrder ID"));

        WorkResult workResult = WorkResult.builder()
                .workOrder(workOrder)
                .completedQuantity(requestDto.getCompletedQuantity())
                .defectiveQuantity(requestDto.getDefectiveQuantity())
                .startTime(requestDto.getStartTime())
                .endTime(requestDto.getEndTime())
                .build();

        WorkResult savedResult = workResultRepository.save(workResult);
        return new WorkResultResponseDto(savedResult);
    }
}