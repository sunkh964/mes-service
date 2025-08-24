package com.example.mes_service.Controller;

import com.example.mes_service.Service.QualityControlService;
import com.example.mes_service.dto.QualityControlCreateRequestDto;
import com.example.mes_service.dto.QualityControlResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quality-controls")
@RequiredArgsConstructor
public class QualityControlController {

    private final QualityControlService qualityControlService;

    @GetMapping
    public ResponseEntity<List<QualityControlResponseDto>> getAllQualityControls() {
        return ResponseEntity.ok(qualityControlService.findAllQualityControls());
    }

    @PostMapping
    public ResponseEntity<QualityControlResponseDto> createQualityControl(@RequestBody QualityControlCreateRequestDto requestDto) {
        QualityControlResponseDto createdQc = qualityControlService.createQualityControl(requestDto);
        return new ResponseEntity<>(createdQc, HttpStatus.CREATED);
    }
}
