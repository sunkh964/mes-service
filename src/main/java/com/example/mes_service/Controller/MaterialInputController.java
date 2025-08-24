package com.example.mes_service.Controller;

import com.example.mes_service.Service.MaterialInputService;
import com.example.mes_service.dto.MaterialInputCreateRequestDto;
import com.example.mes_service.dto.MaterialInputResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material-inputs")
@RequiredArgsConstructor
public class MaterialInputController {

    private final MaterialInputService materialInputService;

    @GetMapping
    public ResponseEntity<List<MaterialInputResponseDto>> getAllMaterialInputs() {
        return ResponseEntity.ok(materialInputService.findAllMaterialInputs());
    }

    @PostMapping
    public ResponseEntity<MaterialInputResponseDto> createMaterialInput(@RequestBody MaterialInputCreateRequestDto requestDto) {
        MaterialInputResponseDto createdInput = materialInputService.createMaterialInput(requestDto);
        return new ResponseEntity<>(createdInput, HttpStatus.CREATED);
    }
}
