package com.example.mes_service.Service;

import com.example.mes_service.Entity.WorkCenter;
import com.example.mes_service.Repository.WorkCenterRepository;
import com.example.mes_service.dto.WorkCenterCreateRequestDto;
import com.example.mes_service.dto.WorkCenterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkCenterService {

    private final WorkCenterRepository workCenterRepository;

    // 모든 작업장 조회
    public List<WorkCenterResponseDto> findAllWorkCenters() {
        return workCenterRepository.findAll().stream()
                .map(WorkCenterResponseDto::new)
                .collect(Collectors.toList());
    }

    // 작업장 생성
    @Transactional
    public WorkCenterResponseDto createWorkCenter(WorkCenterCreateRequestDto requestDto) {
        WorkCenter workCenter = WorkCenter.builder()
                .workCenterId(requestDto.getWorkCenterId())
                .workCenterName(requestDto.getWorkCenterName())
                .location(requestDto.getLocation())
                .isActive(requestDto.isActive())
                .build();

        WorkCenter savedWorkCenter = workCenterRepository.save(workCenter);
        return new WorkCenterResponseDto(savedWorkCenter);
    }
}