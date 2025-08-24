package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "material_outputs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialOutput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "output_id")
    private Integer outputId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 50)
    private String destination;

    @CreationTimestamp
    @Column(name = "output_date", updatable = false)
    private LocalDateTime outputDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    @Column(name = "warehouse_name", length = 50)
    private String warehouseName;
}