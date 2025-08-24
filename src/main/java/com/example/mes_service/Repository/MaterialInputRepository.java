// File: src/main/java/com/example/mes_service/Repository/MaterialInputRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.MaterialInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialInputRepository extends JpaRepository<MaterialInput, Integer> {
}