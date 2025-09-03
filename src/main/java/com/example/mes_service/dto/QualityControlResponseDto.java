package com.example.mes_service.dto;

import com.example.mes_service.Entity.QualityControl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QualityControlResponseDto {

    private Integer qcId;
    private Integer workOrderId;
    private LocalDateTime inspectionDate;
    private String result;
    private String notes;

    // ✨ 검사자 ID와 이름을 보여줄 필드 추가
    private String inspectorId;
    private String inspectorName;

    public QualityControlResponseDto(QualityControl qc) {
        this.qcId = qc.getQcId();
        this.workOrderId = qc.getWorkOrder().getWorkOrderId();
        this.inspectionDate = qc.getInspectionDate();
        this.result = qc.getResult();
        this.notes = qc.getNotes();

        // ✨ 검사자 정보가 있을 경우에만 매핑
        if (qc.getInspector() != null) {
            this.inspectorId = qc.getInspector().getWorkerId();
            this.inspectorName = qc.getInspector().getWorkerName();
        }
    }
}