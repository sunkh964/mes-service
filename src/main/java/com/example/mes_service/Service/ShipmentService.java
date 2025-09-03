package com.example.mes_service.Service;

import com.example.mes_service.Entity.Block;
import com.example.mes_service.Entity.Shipment;
import com.example.mes_service.Repository.BlockRepository;
import com.example.mes_service.Repository.ShipmentRepository;
import com.example.mes_service.dto.ShipmentCreateRequestDto;
import com.example.mes_service.dto.ShipmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final BlockRepository blockRepository;

    public List<ShipmentResponseDto> findAllShipments() {
        return shipmentRepository.findAll().stream()
                .map(ShipmentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ShipmentResponseDto createShipment(ShipmentCreateRequestDto requestDto) {
        Block block = blockRepository.findById(requestDto.getBlockId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Block ID"));

        Shipment shipment = Shipment.builder()
                .block(block)
                .destination(requestDto.getDestination())
                .status(requestDto.getStatus())
                .notes(requestDto.getNotes())
                .build();

        Shipment savedShipment = shipmentRepository.save(shipment);
        return new ShipmentResponseDto(savedShipment);
    }
}