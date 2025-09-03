package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "final_inspections")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinalInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inspection_id")
    private Integer inspectionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder; // 어떤 작업지시에 대한 검사인지

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inspector_id")
    private Worker inspector; // 검사자

    @CreationTimestamp
    @Column(name = "inspection_date", updatable = false)
    private LocalDateTime inspectionDate;

    @Column(nullable = false, length = 20)
    private String result; // 결과 (예: '합격', '불합격')

    @Column(length = 255)
    private String notes; // 메모
}