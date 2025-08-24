package com.example.mes_service.Service;

import com.example.mes_service.Entity.Block;
import com.example.mes_service.Entity.Process;
import com.example.mes_service.Entity.ProcessPlan;
import com.example.mes_service.Repository.BlockRepository;
import com.example.mes_service.Repository.ProcessPlanRepository;
import com.example.mes_service.Repository.ProcessRepository;
import com.example.mes_service.dto.ProcessPlanCreateRequestDto;
import com.example.mes_service.dto.ProcessPlanResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProcessPlanService {

    private final ProcessPlanRepository processPlanRepository;
    private final BlockRepository blockRepository;
    private final ProcessRepository processRepository;

    public List<ProcessPlanResponseDto> findAllProcessPlans() {
        return processPlanRepository.findAll().stream()
                .map(ProcessPlanResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProcessPlanResponseDto createProcessPlan(ProcessPlanCreateRequestDto requestDto) {
        Block block = blockRepository.findById(requestDto.getBlockId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Block ID"));
        Process process = processRepository.findById(requestDto.getProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Process ID"));

        ProcessPlan processPlan = ProcessPlan.builder()
                .block(block)
                .process(process)
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .expectedWorkload(requestDto.getExpectedWorkload())
                .build();

        ProcessPlan savedPlan = processPlanRepository.save(processPlan);
        return new ProcessPlanResponseDto(savedPlan);
    }
}
