package com.example.mes_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "workers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @Column(name = "worker_id", length = 20)
    private String workerId;

    @Column(name = "worker_name", nullable = false, length = 30)
    private String workerName;

    @Column(length = 30)
    private String department;

    @Column(length = 30)
    private String position;
}
