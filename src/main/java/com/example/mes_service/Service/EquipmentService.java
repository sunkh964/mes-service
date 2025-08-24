// File: src/main/java/com/example/mes_service/Service/EquipmentService.java
package com.example.mes_service.Service;

import com.example.mes_service.Entity.Equipment;
import com.example.mes_service.Entity.WorkCenter;
import com.example.mes_service.Repository.EquipmentRepository;
import com.example.mes_service.Repository.WorkCenterRepository;
import com.example.mes_service.dto.EquipmentCreateRequestDto;
import com.example.mes_service.dto.EquipmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final WorkCenterRepository workCenterRepository;

    // 모든 장비 조회
    public List<EquipmentResponseDto> findAllEquipment() {
        return equipmentRepository.findAll().stream()
                .map(EquipmentResponseDto::new)
                .collect(Collectors.toList());
    }

    // 장비 생성
    @Transactional
    public EquipmentResponseDto createEquipment(EquipmentCreateRequestDto requestDto) {
        WorkCenter workCenter = workCenterRepository.findById(requestDto.getWorkCenterId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkCenter ID"));

        Equipment equipment = Equipment.builder()
                .equipmentId(requestDto.getEquipmentId())
                .equipmentName(requestDto.getEquipmentName())
                .modelName(requestDto.getModelName())
                .status(requestDto.getStatus())
                .lastInspectionDate(requestDto.getLastInspectionDate())
                .workCenter(workCenter)
                .build();

        Equipment savedEquipment = equipmentRepository.save(equipment);
        return new EquipmentResponseDto(savedEquipment);
    }
}
