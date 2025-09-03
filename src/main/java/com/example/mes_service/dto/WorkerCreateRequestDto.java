package com.example.mes_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerCreateRequestDto {
    private String workerId;
    private String workerName;
    private String department;
    private String position;
}
