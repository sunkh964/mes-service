package com.example.mes_service.dto;

import com.example.mes_service.Entity.DefectReport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DefectReportResponseDto {
    private Integer defectId;
    private Integer qcId;
    private Integer quantity;
    private LocalDateTime recordedAt;

    public DefectReportResponseDto(DefectReport defectReport) {
        this.defectId = defectReport.getDefectId();
        this.qcId = defectReport.getQualityControl().getQcId();
        this.quantity = defectReport.getQuantity();
        this.recordedAt = defectReport.getRecordedAt();
    }
}