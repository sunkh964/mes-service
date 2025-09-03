package com.example.mes_service.dto;

import com.example.mes_service.Entity.Worker;
import lombok.Getter;

@Getter
public class WorkerResponseDto {
    private final String workerId;
    private final String workerName;
    private final String department;
    private final String position;

    public WorkerResponseDto(Worker worker) {
        this.workerId = worker.getWorkerId();
        this.workerName = worker.getWorkerName();
        this.department = worker.getDepartment();
        this.position = worker.getPosition();
    }
}
