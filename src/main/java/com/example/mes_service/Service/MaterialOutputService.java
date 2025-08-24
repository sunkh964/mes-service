package com.example.mes_service.Service;

import com.example.mes_service.Entity.MaterialOutput;
import com.example.mes_service.Entity.WorkOrder;
import com.example.mes_service.Repository.MaterialOutputRepository;
import com.example.mes_service.Repository.WorkOrderRepository;
import com.example.mes_service.dto.MaterialOutputCreateRequestDto;
import com.example.mes_service.dto.MaterialOutputResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MaterialOutputService {

    private final MaterialOutputRepository materialOutputRepository;
    private final WorkOrderRepository workOrderRepository;

    public List<MaterialOutputResponseDto> findAllMaterialOutputs() {
        return materialOutputRepository.findAll().stream()
                .map(MaterialOutputResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public MaterialOutputResponseDto createMaterialOutput(MaterialOutputCreateRequestDto requestDto) {
        WorkOrder workOrder = workOrderRepository.findById(requestDto.getWorkOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkOrder ID"));

        MaterialOutput materialOutput = MaterialOutput.builder()
                .quantity(requestDto.getQuantity())
                .destination(requestDto.getDestination())
                .workOrder(workOrder)
                .warehouseName(requestDto.getWarehouseName())
                .build();

        MaterialOutput savedOutput = materialOutputRepository.save(materialOutput);
        return new MaterialOutputResponseDto(savedOutput);
    }
}
