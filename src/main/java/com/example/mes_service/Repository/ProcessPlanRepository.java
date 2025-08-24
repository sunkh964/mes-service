// File: src/main/java/com/example/mes_service/Repository/ProcessPlanRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.ProcessPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessPlanRepository extends JpaRepository<ProcessPlan, Integer> {
}