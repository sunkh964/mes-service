// File: src/main/java/com/example/mes_service/Repository/ProcessRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<Process, String> {
}