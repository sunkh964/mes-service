package com.example.mes_service.Controller;

import com.example.mes_service.Service.WorkCenterService;
import com.example.mes_service.dto.WorkCenterCreateRequestDto;
import com.example.mes_service.dto.WorkCenterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-centers")
@RequiredArgsConstructor
public class WorkCenterController {

    private final WorkCenterService workCenterService;

    @GetMapping
    public ResponseEntity<List<WorkCenterResponseDto>> getAllWorkCenters() {
        return ResponseEntity.ok(workCenterService.findAllWorkCenters());
    }

    @PostMapping
    public ResponseEntity<WorkCenterResponseDto> createWorkCenter(@RequestBody WorkCenterCreateRequestDto requestDto) {
        WorkCenterResponseDto createdWorkCenter = workCenterService.createWorkCenter(requestDto);
        return new ResponseEntity<>(createdWorkCenter, HttpStatus.CREATED);
    }
}