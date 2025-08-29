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

    // ✨ 설비 정보 수정
    @Transactional
    public EquipmentResponseDto updateEquipment(String equipmentId, EquipmentCreateRequestDto requestDto) {
        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Equipment ID"));

        // workCenter는 ID로 다시 찾아와서 설정
        WorkCenter workCenter = workCenterRepository.findById(requestDto.getWorkCenterId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkCenter ID"));

        equipment.setEquipmentName(requestDto.getEquipmentName());
        equipment.setModelName(requestDto.getModelName());
        equipment.setStatus(requestDto.getStatus());
        equipment.setLastInspectionDate(requestDto.getLastInspectionDate());
        equipment.setWorkCenter(workCenter);

        return new EquipmentResponseDto(equipment);
    }

    // ✨ 설비 정보 삭제
    @Transactional
    public void deleteEquipment(String equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }
}
