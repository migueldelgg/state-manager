package com.migueldelgado.state_manager.domain.repository;

import com.migueldelgado.state_manager.domain.entity.StatusHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusHistoryRepository extends JpaRepository<StatusHistoryEntity, Long> {
}
