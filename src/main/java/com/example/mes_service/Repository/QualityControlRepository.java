// File: src/main/java/com/example/mes_service/Repository/QualityControlRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.QualityControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityControlRepository extends JpaRepository<QualityControl, Integer> {
}