// File: src/main/java/com/example/mes_service/Controller/EquipmentController.java
package com.example.mes_service.Controller;

import com.example.mes_service.Service.EquipmentService;
import com.example.mes_service.dto.EquipmentCreateRequestDto;
import com.example.mes_service.dto.EquipmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    // 모든 장비 조회 API
    @GetMapping
    public ResponseEntity<List<EquipmentResponseDto>> getAllEquipment() {
        List<EquipmentResponseDto> equipmentList = equipmentService.findAllEquipment();
        return ResponseEntity.ok(equipmentList);
    }

    // 장비 생성 API
    @PostMapping
    public ResponseEntity<EquipmentResponseDto> createEquipment(@RequestBody EquipmentCreateRequestDto requestDto) {
        EquipmentResponseDto createdEquipment = equipmentService.createEquipment(requestDto);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }

    // ✨ 설비 정보 수정 API
    @PutMapping("/{id}")
    public ResponseEntity<EquipmentResponseDto> updateEquipment(@PathVariable String id, @RequestBody EquipmentCreateRequestDto requestDto) {
        return ResponseEntity.ok(equipmentService.updateEquipment(id, requestDto));
    }

    // ✨ 설비 정보 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable String id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }
}
