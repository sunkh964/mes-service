package com.example.mes_service.Service;

import com.example.mes_service.Entity.Block;
import com.example.mes_service.Entity.WorkCenter;
import com.example.mes_service.Repository.BlockRepository;
import com.example.mes_service.Repository.WorkCenterRepository;
import com.example.mes_service.dto.BlockCreateRequestDto;
import com.example.mes_service.dto.BlockResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BlockService {

    private final BlockRepository blockRepository;
    private final WorkCenterRepository workCenterRepository;

    public List<BlockResponseDto> findAllBlocks() {
        return blockRepository.findAll().stream()
                .map(BlockResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public BlockResponseDto createBlock(BlockCreateRequestDto requestDto) {
        WorkCenter workCenter = workCenterRepository.findById(requestDto.getWorkCenterId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid WorkCenter ID: " + requestDto.getWorkCenterId()));

        Block block = Block.builder()
                .blockName(requestDto.getBlockName())
                .blockType(requestDto.getBlockType())
                .dimensions(requestDto.getDimensions())
                .weight(requestDto.getWeight())
                .workCenter(workCenter)
                .plannedStartDate(requestDto.getPlannedStartDate())
                .plannedEndDate(requestDto.getPlannedEndDate())
                .build();

        Block savedBlock = blockRepository.save(block);
        return new BlockResponseDto(savedBlock);
    }
}