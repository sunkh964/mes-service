package com.example.mes_service.Repository;

import com.example.mes_service.Entity.FinalInspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalInspectionRepository extends JpaRepository<FinalInspection, Integer> {
}