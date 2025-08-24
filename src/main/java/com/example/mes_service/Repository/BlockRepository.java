// File: src/main/java/com/example/mes_service/Repository/BlockRepository.java
package com.example.mes_service.Repository;

import com.example.mes_service.Entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
}
