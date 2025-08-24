package com.example.mes_service.Controller;

import com.example.mes_service.Service.MaterialOutputService;
import com.example.mes_service.dto.MaterialOutputCreateRequestDto;
import com.example.mes_service.dto.MaterialOutputResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material-outputs")
@RequiredArgsConstructor
public class MaterialOutputController {

    private final MaterialOutputService materialOutputService;

    @GetMapping
    public ResponseEntity<List<MaterialOutputResponseDto>> getAllMaterialOutputs() {
        return ResponseEntity.ok(materialOutputService.findAllMaterialOutputs());
    }

    @PostMapping
    public ResponseEntity<MaterialOutputResponseDto> createMaterialOutput(@RequestBody MaterialOutputCreateRequestDto requestDto) {
        MaterialOutputResponseDto createdOutput = materialOutputService.createMaterialOutput(requestDto);
        return new ResponseEntity<>(createdOutput, HttpStatus.CREATED);
    }
}