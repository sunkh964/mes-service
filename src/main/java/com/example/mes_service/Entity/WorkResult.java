package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "work_results")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    @Column(name = "completed_quantity", nullable = false)
    private Integer completedQuantity;

    @Column(name = "defective_quantity", nullable = false)
    private Integer defectiveQuantity = 0;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @CreationTimestamp
    @Column(name = "input_time", updatable = false)
    private LocalDateTime inputTime;
}