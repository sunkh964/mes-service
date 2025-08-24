package com.example.mes_service.dto;

import com.example.mes_service.Entity.Block;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class BlockResponseDto {

    private Integer blockId;
    private String blockName;
    private String blockType;
    private String dimensions;
    private Integer weight;
    private String currentStatus;
    private String workCenterId;
    private LocalDate plannedStartDate;
    private LocalDate plannedEndDate;
    private LocalDate actualStartDate;
    private LocalDate actualEndDate;

    public BlockResponseDto(Block block) {
        this.blockId = block.getBlockId();
        this.blockName = block.getBlockName();
        this.blockType = block.getBlockType();
        this.dimensions = block.getDimensions();
        this.weight = block.getWeight();
        this.currentStatus = block.getCurrentStatus();
        if (block.getWorkCenter() != null) {
            this.workCenterId = block.getWorkCenter().getWorkCenterId();
        }
        this.plannedStartDate = block.getPlannedStartDate();
        this.plannedEndDate = block.getPlannedEndDate();
        this.actualStartDate = block.getActualStartDate();
        this.actualEndDate = block.getActualEndDate();
    }
}
