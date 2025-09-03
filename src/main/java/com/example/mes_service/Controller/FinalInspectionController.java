package com.example.mes_service.Controller;

import com.example.mes_service.Service.FinalInspectionService;
import com.example.mes_service.dto.FinalInspectionCreateRequestDto;
import com.example.mes_service.dto.FinalInspectionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/final-inspections")
@RequiredArgsConstructor
public class FinalInspectionController {

    private final FinalInspectionService finalInspectionService;

    @GetMapping
    public ResponseEntity<List<FinalInspectionResponseDto>> getAllFinalInspections() {
        return ResponseEntity.ok(finalInspectionService.findAllFinalInspections());
    }

    @PostMapping
    public ResponseEntity<FinalInspectionResponseDto> createFinalInspection(@RequestBody FinalInspectionCreateRequestDto requestDto) {
        return new ResponseEntity<>(finalInspectionService.createFinalInspection(requestDto), HttpStatus.CREATED);
    }
}