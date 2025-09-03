package com.example.mes_service.Service;

import com.example.mes_service.Entity.FinalInspection;
import com.example.mes_service.Entity.WorkOrder;
import com.example.mes_service.Entity.Worker;
import com.example.mes_service.Repository.FinalInspectionRepository;
import com.example.mes_service.Repository.WorkOrderRepository;
import com.example.mes_service.Repository.WorkerRepository;
import com.example.mes_service.dto.FinalInspectionCreateRequestDto;
import com.example.mes_service.dto.FinalInspectionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FinalInspectionService {

    private final FinalInspectionRepository finalInspectionRepository;
    private final WorkOrderRepository workOrderRepository;
    private final WorkerRepository workerRepository;

    public List<FinalInspectionResponseDto> findAllFinalInspections() {
        return finalInspectionRepository.findAll().stream()
                .map(FinalInspectionResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public FinalInspectionResponseDto createFinalInspection(FinalInspectionCreateRequestDto requestDto) {
        WorkOrder workOrder = workOrderRepository.findById(requestDto.getWorkOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkOrder ID"));

        Worker inspector = workerRepository.findById(requestDto.getInspectorId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Worker ID"));

        FinalInspection finalInspection = FinalInspection.builder()
                .workOrder(workOrder)
                .inspector(inspector)
                .result(requestDto.getResult())
                .notes(requestDto.getNotes())
                .build();

        FinalInspection savedInspection = finalInspectionRepository.save(finalInspection);
        return new FinalInspectionResponseDto(savedInspection);
    }
}
