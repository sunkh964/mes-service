package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "blocks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "block_id")
    private Integer blockId;

    @Column(name = "block_name", nullable = false, length = 50)
    private String blockName;

    @Column(name = "block_type", length = 20)
    private String blockType;

    @Column(length = 50)
    private String dimensions;

    private Integer weight;

    @Column(name = "current_status", length = 20)
    private String currentStatus = "planned";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_center_id")
    private WorkCenter workCenter;

    @Column(name = "planned_start_date")
    private LocalDate plannedStartDate;

    @Column(name = "planned_end_date")
    private LocalDate plannedEndDate;

    @Column(name = "actual_start_date")
    private LocalDate actualStartDate;

    @Column(name = "actual_end_date")
    private LocalDate actualEndDate;
}