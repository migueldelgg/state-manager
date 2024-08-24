package com.migueldelgado.state_manager.domain.repository;

import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateEntity, Long> {
}
