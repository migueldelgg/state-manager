package com.migueldelgado.state_manager.domain.repository;

import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import com.migueldelgado.state_manager.domain.entity.state.UFEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<StateEntity, Long> {

    Optional<StateEntity> findByUf(UFEnum uf);

}
