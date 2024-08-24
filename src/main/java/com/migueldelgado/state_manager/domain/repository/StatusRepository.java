package com.migueldelgado.state_manager.domain.repository;

import com.migueldelgado.state_manager.domain.entity.status.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
}
