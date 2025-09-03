package com.example.mes_service.Controller;

import com.example.mes_service.Service.WorkerService;
import com.example.mes_service.dto.WorkerCreateRequestDto;
import com.example.mes_service.dto.WorkerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<WorkerResponseDto>> getAllWorkers() {
        return ResponseEntity.ok(workerService.findAllWorkers());
    }

    @PostMapping
    public ResponseEntity<WorkerResponseDto> createWorker(@RequestBody WorkerCreateRequestDto requestDto) {
        return new ResponseEntity<>(workerService.createWorker(requestDto), HttpStatus.CREATED);
    }
}