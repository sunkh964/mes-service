package com.example.mes_service.Service;

import com.example.mes_service.Entity.Process;
import com.example.mes_service.Repository.ProcessRepository;
import com.example.mes_service.dto.ProcessCreateRequestDto;
import com.example.mes_service.dto.ProcessResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProcessService {

    private final ProcessRepository processRepository;

    public List<ProcessResponseDto> findAllProcesses() {
        return processRepository.findAll().stream()
                .map(ProcessResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProcessResponseDto createProcess(ProcessCreateRequestDto requestDto) {
        Process process = Process.builder()
                .processId(requestDto.getProcessId())
                .processName(requestDto.getProcessName())
                .processInfo(requestDto.getProcessInfo())
                .processSequence(requestDto.getProcessSequence())
                .build();

        Process savedProcess = processRepository.save(process);
        return new ProcessResponseDto(savedProcess);
    }

    // ✨ 공정 수정 (새로 추가)
    @Transactional
    public ProcessResponseDto updateProcess(String processId, ProcessCreateRequestDto requestDto) {
        Process process = processRepository.findById(processId)
                .orElseThrow(() -> new IllegalArgumentException("해당 공정이 없습니다. id=" + processId));

        process.setProcessName(requestDto.getProcessName());
        process.setProcessInfo(requestDto.getProcessInfo());
        process.setProcessSequence(requestDto.getProcessSequence());

        return new ProcessResponseDto(process);
    }

    // ✨ 공정 삭제 (새로 추가)
    @Transactional
    public void deleteProcess(String processId) {
        Process process = processRepository.findById(processId)
                .orElseThrow(() -> new IllegalArgumentException("해당 공정이 없습니다. id=" + processId));
        processRepository.delete(process);
    }
}