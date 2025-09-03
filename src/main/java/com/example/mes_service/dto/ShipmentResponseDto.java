package com.example.mes_service.dto;

import com.example.mes_service.Entity.Shipment;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ShipmentResponseDto {
    private final Integer shipmentId;
    private final Integer blockId;
    private final String blockName; // 블록 이름도 함께 보내주면 편리합니다.
    private final LocalDateTime shipmentDate;
    private final String destination;
    private final String status;
    private final String notes;

    public ShipmentResponseDto(Shipment shipment) {
        this.shipmentId = shipment.getShipmentId();
        this.blockId = shipment.getBlock().getBlockId();
        this.blockName = shipment.getBlock().getBlockName();
        this.shipmentDate = shipment.getShipmentDate();
        this.destination = shipment.getDestination();
        this.status = shipment.getStatus();
        this.notes = shipment.getNotes();
    }
}