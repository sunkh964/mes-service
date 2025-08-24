package com.example.mes_service.Controller;

import com.example.mes_service.Service.BlockService;
import com.example.mes_service.dto.BlockCreateRequestDto;
import com.example.mes_service.dto.BlockResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocks")
@RequiredArgsConstructor
public class BlockController {

    private final BlockService blockService;

    @GetMapping
    public ResponseEntity<List<BlockResponseDto>> getAllBlocks() {
        return ResponseEntity.ok(blockService.findAllBlocks());
    }

    @PostMapping
    public ResponseEntity<BlockResponseDto> createBlock(@RequestBody BlockCreateRequestDto requestDto) {
        BlockResponseDto createdBlock = blockService.createBlock(requestDto);
        return new ResponseEntity<>(createdBlock, HttpStatus.CREATED);
    }
}
