package com.migueldelgado.state_manager.domain.entity;

import com.migueldelgado.state_manager.domain.entity.integration.IntegrationEntity;
import com.migueldelgado.state_manager.domain.entity.status.StatusEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name = "tb_historico")
public class StatusHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historico_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "integration_id", referencedColumnName = "integration_id")
    private IntegrationEntity integration;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private StatusEntity status;

    @Column(name = "change_timestamp")
    @CreationTimestamp
    private Instant changeTimestamp;
}
