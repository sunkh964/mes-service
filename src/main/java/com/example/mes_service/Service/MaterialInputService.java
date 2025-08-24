package com.example.mes_service.Service;

import com.example.mes_service.Entity.MaterialInput;
import com.example.mes_service.Repository.MaterialInputRepository;
import com.example.mes_service.dto.MaterialInputCreateRequestDto;
import com.example.mes_service.dto.MaterialInputResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MaterialInputService {

    private final MaterialInputRepository materialInputRepository;

    public List<MaterialInputResponseDto> findAllMaterialInputs() {
        return materialInputRepository.findAll().stream()
                .map(MaterialInputResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public MaterialInputResponseDto createMaterialInput(MaterialInputCreateRequestDto requestDto) {
        MaterialInput materialInput = MaterialInput.builder()
                .quantity(requestDto.getQuantity())
                .warehouseName(requestDto.getWarehouseName())
                .build();

        MaterialInput savedInput = materialInputRepository.save(materialInput);
        return new MaterialInputResponseDto(savedInput);
    }
}
