package com.example.mes_service.Controller;

import com.example.mes_service.Service.ProcessPlanService;
import com.example.mes_service.dto.ProcessPlanCreateRequestDto;
import com.example.mes_service.dto.ProcessPlanResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/process-plans")
@RequiredArgsConstructor
public class ProcessPlanController {

    private final ProcessPlanService processPlanService;

    @GetMapping
    public ResponseEntity<List<ProcessPlanResponseDto>> getAllProcessPlans() {
        return ResponseEntity.ok(processPlanService.findAllProcessPlans());
    }

    @PostMapping
    public ResponseEntity<ProcessPlanResponseDto> createProcessPlan(@RequestBody ProcessPlanCreateRequestDto requestDto) {
        ProcessPlanResponseDto createdPlan = processPlanService.createProcessPlan(requestDto);
        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
    }
}