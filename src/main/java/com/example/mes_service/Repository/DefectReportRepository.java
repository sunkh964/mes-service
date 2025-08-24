// File: src/main/java/com/example/mes_service/Repository/DefectReportRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.DefectReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectReportRepository extends JpaRepository<DefectReport, Integer> {
}
