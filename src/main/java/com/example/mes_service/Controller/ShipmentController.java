package com.example.mes_service.Controller;

import com.example.mes_service.Service.ShipmentService;
import com.example.mes_service.dto.ShipmentCreateRequestDto;
import com.example.mes_service.dto.ShipmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping
    public ResponseEntity<List<ShipmentResponseDto>> getAllShipments() {
        return ResponseEntity.ok(shipmentService.findAllShipments());
    }

    @PostMapping
    public ResponseEntity<ShipmentResponseDto> createShipment(@RequestBody ShipmentCreateRequestDto requestDto) {
        return new ResponseEntity<>(shipmentService.createShipment(requestDto), HttpStatus.CREATED);
    }
}