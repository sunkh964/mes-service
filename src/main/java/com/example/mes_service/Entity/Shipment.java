package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
    private Integer shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "block_id", nullable = false)
    private Block block; // 어떤 블록을 출하하는지

    @CreationTimestamp
    @Column(name = "shipment_date", updatable = false)
    private LocalDateTime shipmentDate;

    @Column(length = 100)
    private String destination; // 목적지

    @Column(length = 20)
    private String status = "준비중"; // 상태 (예: '준비중', '완료')

    @Column(length = 255)
    private String notes;
}