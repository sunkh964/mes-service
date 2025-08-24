package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessCreateRequestDto {
    private String processId;
    private String processName;
    private String processInfo;
    private Integer processSequence;
}