package com.example.mes_service.Controller;

import com.example.mes_service.Service.WorkOrderService;
import com.example.mes_service.dto.WorkOrderCreateRequestDto;
import com.example.mes_service.dto.WorkOrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    // ✨ GET 요청이 파라미터를 받을 수 있도록 수정
    @GetMapping
    public ResponseEntity<List<WorkOrderResponseDto>> getAllWorkOrders(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String workCenterId
    ) {
        return ResponseEntity.ok(workOrderService.findAllWorkOrders(status, workCenterId));
    }

    @PostMapping
    public ResponseEntity<WorkOrderResponseDto> createWorkOrder(@RequestBody WorkOrderCreateRequestDto requestDto) {
        WorkOrderResponseDto createdWorkOrder = workOrderService.createWorkOrder(requestDto);
        return new ResponseEntity<>(createdWorkOrder, HttpStatus.CREATED);
    }
}