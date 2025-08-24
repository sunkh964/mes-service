package com.example.mes_service.Controller;

import com.example.mes_service.Service.DefectReportService;
import com.example.mes_service.dto.DefectReportCreateRequestDto;
import com.example.mes_service.dto.DefectReportResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defect-reports")
@RequiredArgsConstructor
public class DefectReportController {

    private final DefectReportService defectReportService;

    @GetMapping
    public ResponseEntity<List<DefectReportResponseDto>> getAllDefectReports() {
        return ResponseEntity.ok(defectReportService.findAllDefectReports());
    }

    @PostMapping
    public ResponseEntity<DefectReportResponseDto> createDefectReport(@RequestBody DefectReportCreateRequestDto requestDto) {
        DefectReportResponseDto createdReport = defectReportService.createDefectReport(requestDto);
        return new ResponseEntity<>(createdReport, HttpStatus.CREATED);
    }
}
