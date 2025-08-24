package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BlockCreateRequestDto {

    private String blockName;
    private String blockType;
    private String dimensions;
    private Integer weight;
    private String workCenterId;
    private LocalDate plannedStartDate;
    private LocalDate plannedEndDate;
}