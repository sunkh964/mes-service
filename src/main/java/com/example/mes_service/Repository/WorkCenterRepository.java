// File: src/main/java/com/example/mes_service/domain/WorkCenterRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.WorkCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkCenterRepository extends JpaRepository<WorkCenter, String> {
}