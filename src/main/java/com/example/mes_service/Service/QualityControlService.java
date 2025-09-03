package com.example.mes_service.Service;

import com.example.mes_service.Entity.QualityControl;
import com.example.mes_service.Entity.WorkOrder;
import com.example.mes_service.Entity.Worker; // Worker import
import com.example.mes_service.Repository.QualityControlRepository;
import com.example.mes_service.Repository.WorkOrderRepository;
import com.example.mes_service.Repository.WorkerRepository; // WorkerRepository import
import com.example.mes_service.dto.QualityControlCreateRequestDto;
import com.example.mes_service.dto.QualityControlResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QualityControlService {

    private final QualityControlRepository qualityControlRepository;
    private final WorkOrderRepository workOrderRepository;
    private final WorkerRepository workerRepository; // ✨ WorkerRepository 주입 추가

    public List<QualityControlResponseDto> findAllQualityControls() {
        return qualityControlRepository.findAll().stream()
                .map(QualityControlResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public QualityControlResponseDto createQualityControl(QualityControlCreateRequestDto requestDto) {
        WorkOrder workOrder = workOrderRepository.findById(requestDto.getWorkOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkOrder ID"));

        // ✨ 1. inspectorId로 Worker 객체를 찾아옵니다.
        Worker inspector = workerRepository.findById(requestDto.getInspectorId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Worker ID for inspector"));

        QualityControl qualityControl = QualityControl.builder()
                .workOrder(workOrder)
                // ✨ 2. inspectorId(...) 대신 inspector(Worker객체)를 전달합니다.
                .inspector(inspector)
                .result(requestDto.getResult())
                .notes(requestDto.getNotes())
                .build();

        QualityControl savedQc = qualityControlRepository.save(qualityControl);
        return new QualityControlResponseDto(savedQc);
    }
}