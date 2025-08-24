// File: src/main/java/com/example/mes_service/entity/Equipment.java
package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @Column(name = "equipment_id", length = 20)
    private String equipmentId;

    @Column(name = "equipment_name", nullable = false, length = 50)
    private String equipmentName;

    @Column(name = "model_name", length = 50)
    private String modelName;

    @Column(length = 20)
    private String status = "idle";

    @Column(name = "last_inspection_date")
    private LocalDate lastInspectionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_center_id")
    @ToString.Exclude
    private WorkCenter workCenter;
}
