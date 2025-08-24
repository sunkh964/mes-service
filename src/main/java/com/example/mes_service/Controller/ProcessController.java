package com.example.mes_service.Controller;

import com.example.mes_service.Service.ProcessService;
import com.example.mes_service.dto.ProcessCreateRequestDto;
import com.example.mes_service.dto.ProcessResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processes")
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessService processService;

    @GetMapping
    public ResponseEntity<List<ProcessResponseDto>> getAllProcesses() {
        return ResponseEntity.ok(processService.findAllProcesses());
    }

    @PostMapping
    public ResponseEntity<ProcessResponseDto> createProcess(@RequestBody ProcessCreateRequestDto requestDto) {
        ProcessResponseDto createdProcess = processService.createProcess(requestDto);
        return new ResponseEntity<>(createdProcess, HttpStatus.CREATED);
    }
}