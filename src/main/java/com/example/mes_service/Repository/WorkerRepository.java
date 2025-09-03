package com.example.mes_service.Repository;

import com.example.mes_service.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, String> {
}
