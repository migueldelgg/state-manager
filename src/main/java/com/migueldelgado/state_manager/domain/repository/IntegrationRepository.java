package com.migueldelgado.state_manager.domain.repository;

import com.migueldelgado.state_manager.domain.entity.integration.IntegrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegrationRepository extends JpaRepository<IntegrationEntity, Long> {
}
