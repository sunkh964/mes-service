package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "quality_controls")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualityControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qc_id")
    private Integer qcId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    @Column(name = "inspector_id", nullable = false)
    private Integer inspectorId;

    @CreationTimestamp
    @Column(name = "inspection_date", updatable = false)
    private LocalDateTime inspectionDate;

    @Column(name = "result", nullable = false, length = 20)
    private String result;

    @Column(length = 255)
    private String notes;
}