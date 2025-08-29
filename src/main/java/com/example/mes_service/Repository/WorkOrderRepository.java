package com.example.mes_service.Repository;

import com.example.mes_service.Entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer> {

    long countByCurrentStatus(String currentStatus);

    // ✨ 검색 조건을 위한 JPQL 쿼리 추가
    @Query("SELECT wo FROM WorkOrder wo WHERE " +
            "(:status IS NULL OR wo.currentStatus = :status) AND " +
            "(:workCenterId IS NULL OR wo.workCenter.workCenterId = :workCenterId)")
    List<WorkOrder> findByFilters(@Param("status") String status, @Param("workCenterId") String workCenterId);
}