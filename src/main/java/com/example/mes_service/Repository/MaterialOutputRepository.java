// File: src/main/java/com/example/mes_service/Repository/MaterialOutputRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.MaterialOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialOutputRepository extends JpaRepository<MaterialOutput, Integer> {
}
