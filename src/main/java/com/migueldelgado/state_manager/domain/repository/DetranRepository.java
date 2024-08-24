package com.migueldelgado.state_manager.domain.repository;

import com.migueldelgado.state_manager.domain.entity.detran.DetranEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetranRepository extends JpaRepository<DetranEntity, Long> {
}
