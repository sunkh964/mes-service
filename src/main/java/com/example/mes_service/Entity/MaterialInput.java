package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "material_inputs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "input_id")
    private Integer inputId;

    @Column(nullable = false)
    private Integer quantity;

    @CreationTimestamp
    @Column(name = "input_date", updatable = false)
    private LocalDateTime inputDate;

    @Column(name = "warehouse_name", length = 50)
    private String warehouseName;
}