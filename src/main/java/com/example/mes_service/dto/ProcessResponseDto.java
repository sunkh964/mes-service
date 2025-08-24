package com.example.mes_service.dto;

import com.example.mes_service.Entity.Process;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProcessResponseDto {
    private String processId;
    private String processName;
    private String processInfo;
    private Integer processSequence;

    public ProcessResponseDto(Process process) {
        this.processId = process.getProcessId();
        this.processName = process.getProcessName();
        this.processInfo = process.getProcessInfo();
        this.processSequence = process.getProcessSequence();
    }
}