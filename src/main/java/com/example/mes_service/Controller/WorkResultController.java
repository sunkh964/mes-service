package com.example.mes_service.Controller;

import com.example.mes_service.Service.WorkResultService;
import com.example.mes_service.dto.WorkResultCreateRequestDto;
import com.example.mes_service.dto.WorkResultResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-results")
@RequiredArgsConstructor
public class WorkResultController {

    private final WorkResultService workResultService;

    @GetMapping
    public ResponseEntity<List<WorkResultResponseDto>> getAllWorkResults() {
        return ResponseEntity.ok(workResultService.findAllWorkResults());
    }

    @PostMapping
    public ResponseEntity<WorkResultResponseDto> createWorkResult(@RequestBody WorkResultCreateRequestDto requestDto) {
        WorkResultResponseDto createdResult = workResultService.createWorkResult(requestDto);
        return new ResponseEntity<>(createdResult, HttpStatus.CREATED);
    }
}