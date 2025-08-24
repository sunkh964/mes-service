package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "work_centers")
@Getter // <-- 이 어노테이션이 isActive() 메서드를 자동으로 만들어 줍니다.
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkCenter {

    @Id
    @Column(name = "work_center_id", nullable = false, length = 20)
    private String workCenterId;

    @Column(name = "work_center_name", nullable = false, length = 20)
    private String workCenterName;

    @Column(length = 50)
    private String location;

    @Column(name = "is_active")
    private boolean isActive = true;

    // WorkCenter 하나에 여러 개의 Block이 있을 수 있다는 관계 설정
    @OneToMany(mappedBy = "workCenter")
    private List<Block> blocks;

    // WorkCenter 하나에 여러 개의 Equipment가 있을 수 있다는 관계 설정
    @OneToMany(mappedBy = "workCenter")
    private List<Equipment> equipment;
}