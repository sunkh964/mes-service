package com.example.mes_service.Service;

import com.example.mes_service.Entity.DefectReport;
import com.example.mes_service.Entity.QualityControl;
import com.example.mes_service.Repository.DefectReportRepository;
import com.example.mes_service.Repository.QualityControlRepository;
import com.example.mes_service.dto.DefectReportCreateRequestDto;
import com.example.mes_service.dto.DefectReportResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefectReportService {

    private final DefectReportRepository defectReportRepository;
    private final QualityControlRepository qualityControlRepository;

    public List<DefectReportResponseDto> findAllDefectReports() {
        return defectReportRepository.findAll().stream()
                .map(DefectReportResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public DefectReportResponseDto createDefectReport(DefectReportCreateRequestDto requestDto) {
        QualityControl qualityControl = qualityControlRepository.findById(requestDto.getQcId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid QualityControl ID"));

        DefectReport defectReport = DefectReport.builder()
                .qualityControl(qualityControl)
                .quantity(requestDto.getQuantity())
                .build();

        DefectReport savedReport = defectReportRepository.save(defectReport);
        return new DefectReportResponseDto(savedReport);
    }
}
