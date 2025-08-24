// File: src/main/java/com/example/mes_service/Repository/EquipmentRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, String> {
}
