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

    // 모든 작업장 조회 (기존 코드)
    @GetMapping
    public ResponseEntity<List<WorkCenterResponseDto>> getAllWorkCenters() {
        return ResponseEntity.ok(workCenterService.findAllWorkCenters());
    }

    // 작업장 생성 (기존 코드)
    @PostMapping
    public ResponseEntity<WorkCenterResponseDto> createWorkCenter(@RequestBody WorkCenterCreateRequestDto requestDto) {
        WorkCenterResponseDto createdWorkCenter = workCenterService.createWorkCenter(requestDto);
        return new ResponseEntity<>(createdWorkCenter, HttpStatus.CREATED);
    }

    // ✨ 작업장 수정 (새로 추가)
    @PutMapping("/{id}")
    public ResponseEntity<WorkCenterResponseDto> updateWorkCenter(@PathVariable String id, @RequestBody WorkCenterCreateRequestDto requestDto) {
        return ResponseEntity.ok(workCenterService.updateWorkCenter(id, requestDto));
    }

    // ✨ 작업장 삭제 (새로 추가)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkCenter(@PathVariable String id) {
        workCenterService.deleteWorkCenter(id);
        return ResponseEntity.noContent().build(); // 성공적으로 삭제되었으나 반환할 콘텐츠는 없음을 의미
    }
}