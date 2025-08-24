package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "defect_reports")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefectReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "defect_id")
    private Integer defectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qc_id", nullable = false)
    private QualityControl qualityControl;

    @Column(nullable = false)
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "recorded_at", updatable = false)
    private LocalDateTime recordedAt;
}