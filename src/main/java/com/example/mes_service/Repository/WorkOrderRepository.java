// File: src/main/java/com/example/mes_service/Repository/WorkOrderRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {
    long countByCurrentStatus(String currentStatus);
}