// File: src/main/java/com/example/mes_service/Repository/WorkResultRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.WorkResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkResultRepository extends JpaRepository<WorkResult, Integer> {
}