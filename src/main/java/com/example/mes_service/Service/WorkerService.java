package com.example.mes_service.Service;

import com.example.mes_service.Entity.Worker;
import com.example.mes_service.Repository.WorkerRepository;
import com.example.mes_service.dto.WorkerCreateRequestDto;
import com.example.mes_service.dto.WorkerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<WorkerResponseDto> findAllWorkers() {
        return workerRepository.findAll().stream()
                .map(WorkerResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public WorkerResponseDto createWorker(WorkerCreateRequestDto requestDto) {
        Worker worker = Worker.builder()
                .workerId(requestDto.getWorkerId())
                .workerName(requestDto.getWorkerName())
                .department(requestDto.getDepartment())
                .position(requestDto.getPosition())
                .build();
        Worker savedWorker = workerRepository.save(worker);
        return new WorkerResponseDto(savedWorker);
    }
}
