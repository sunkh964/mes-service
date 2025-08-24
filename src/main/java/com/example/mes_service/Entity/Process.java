package com.example.mes_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "processes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Process {

    @Id
    @Column(name = "process_id", nullable = false, length = 20)
    private String processId;

    @Column(name = "process_name", nullable = false, length = 50)
    private String processName;

    @Column(name = "process_info", length = 200)
    private String processInfo;

    @Column(name = "process_sequence")
    private Integer processSequence;
}