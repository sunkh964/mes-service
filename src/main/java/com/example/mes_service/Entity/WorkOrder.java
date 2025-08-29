package com.example.mes_service.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List; // List import 추가

@Getter
@Setter
//... (다른 애너테이션)
@Entity
@Table(name = "work_orders")
public class WorkOrder {

    //... (기존 필드들은 그대로)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_center_id", nullable = false)
    @ToString.Exclude
    private WorkCenter workCenter;

    // ✨ 아래의 @OneToMany 관계들을 추가해주세요.

    // WorkOrder 하나에 여러 개의 WorkResult가 있을 수 있다는 관계 설정
    @OneToMany(mappedBy = "workOrder", fetch = FetchType.LAZY)
    private List<WorkResult> workResults;

    // WorkOrder 하나에 여러 개의 MaterialOutput이 있을 수 있다는 관계 설정
    @OneToMany(mappedBy = "workOrder", fetch = FetchType.LAZY)
    private List<MaterialOutput> materialOutputs;

    // WorkOrder 하나에 여러 개의 QualityControl이 있을 수 있다는 관계 설정
    @OneToMany(mappedBy = "workOrder", fetch = FetchType.LAZY)
    private List<QualityControl> qualityControls;
}