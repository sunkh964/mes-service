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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // 로그 확인용

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkCenterService {

    private final WorkCenterRepository workCenterRepository;

    private static final Logger log = LoggerFactory.getLogger(WorkCenterService.class); // 로그 확인용

    // 모든 작업장 조회 (기존 코드)
    public List<WorkCenterResponseDto> findAllWorkCenters() {
        return workCenterRepository.findAll().stream()
                .map(WorkCenterResponseDto::new)
                .collect(Collectors.toList());
    }

    // 작업장 생성 (기존 코드)
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

    // ✨ 작업장 수정 (새로 추가)
    @Transactional
    public WorkCenterResponseDto updateWorkCenter(String workCenterId, WorkCenterCreateRequestDto requestDto) {

        // ✨ React로부터 받은 isActive 값을 확인하기 위한 로그
        log.info("======= UPDATE LOG =======");
        log.info("Updating WorkCenter ID: {}", workCenterId);
        log.info("Received isActive value from DTO: {}", requestDto.isActive());
        log.info("========================");

        WorkCenter workCenter = workCenterRepository.findById(workCenterId)
                .orElseThrow(() -> new IllegalArgumentException("해당 작업장이 없습니다. id=" + workCenterId));

        // setter를 사용하거나 빌더 패턴을 활용해 엔티티 업데이트
        workCenter.setWorkCenterName(requestDto.getWorkCenterName());
        workCenter.setLocation(requestDto.getLocation());
        workCenter.setActive(requestDto.isActive());

        return new WorkCenterResponseDto(workCenter); // 변경 감지로 자동 저장 및 DTO 반환
    }

    // ✨ 작업장 삭제 (새로 추가)
    @Transactional
    public void deleteWorkCenter(String workCenterId) {
        WorkCenter workCenter = workCenterRepository.findById(workCenterId)
                .orElseThrow(() -> new IllegalArgumentException("해당 작업장이 없습니다. id=" + workCenterId));
        workCenterRepository.delete(workCenter);
    }
}