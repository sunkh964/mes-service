package com.example.mes_service.Service;

import com.example.mes_service.Entity.QualityControl;
import com.example.mes_service.Entity.WorkOrder;
import com.example.mes_service.Repository.QualityControlRepository;
import com.example.mes_service.Repository.WorkOrderRepository;
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

    public List<QualityControlResponseDto> findAllQualityControls() {
        return qualityControlRepository.findAll().stream()
                .map(QualityControlResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public QualityControlResponseDto createQualityControl(QualityControlCreateRequestDto requestDto) {
        WorkOrder workOrder = workOrderRepository.findById(requestDto.getWorkOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkOrder ID"));

        QualityControl qualityControl = QualityControl.builder()
                .workOrder(workOrder)
                .inspectorId(requestDto.getInspectorId())
                .result(requestDto.getResult())
                .notes(requestDto.getNotes())
                .build();

        QualityControl savedQc = qualityControlRepository.save(qualityControl);
        return new QualityControlResponseDto(savedQc);
    }
}
