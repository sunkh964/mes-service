package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    // ✨ 누락되었던 필드들을 여기에 추가합니다.
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

    // --- 기존에 있던 관계 설정들 ---
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

    // --- 기존에 있던 1:N 관계 설정들 ---
    @OneToMany(mappedBy = "workOrder", fetch = FetchType.LAZY)
    private List<WorkResult> workResults;

    @OneToMany(mappedBy = "workOrder", fetch = FetchType.LAZY)
    private List<MaterialOutput> materialOutputs;

    @OneToMany(mappedBy = "workOrder", fetch = FetchType.LAZY)
    private List<QualityControl> qualityControls;
}