// File: src/main/java/com/example/mes_service/entity/WorkOrder.java
package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "work_orders")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_order_id")
    private Integer workOrderId;

    @Column(length = 50)
    private String instruction;

    @Column(name = "quantity_to_produce", nullable = false)
    private Integer quantityToProduce;

    @Column(name = "quantity_produced")
    private Integer quantityProduced = 0;

    @Column(name = "planned_start_date")
    private LocalDateTime plannedStartDate;

    @Column(name = "planned_end_date")
    private LocalDateTime plannedEndDate;

    @Column(name = "actual_start_date")
    private LocalDateTime actualStartDate;

    @Column(name = "actual_end_date")
    private LocalDateTime actualEndDate;

    @Column(name = "current_status", length = 20)
    private String currentStatus = "waiting";

    // 스키마에는 FK 제약조건이 없지만, 관계를 명시적으로 매핑합니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_id", nullable = false)
    @ToString.Exclude
    private Process process;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_plan_id", nullable = false)
    @ToString.Exclude
    private ProcessPlan processPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", nullable = false)
    @ToString.Exclude
    private Block block;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_center_id", nullable = false)
    @ToString.Exclude
    private WorkCenter workCenter;
}