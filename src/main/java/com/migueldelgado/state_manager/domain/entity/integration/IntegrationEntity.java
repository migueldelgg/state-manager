package com.migueldelgado.state_manager.domain.entity.integration;

import com.migueldelgado.state_manager.domain.entity.status.StatusEntity;
import com.migueldelgado.state_manager.domain.entity.detran.DetranEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class IntegrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "integration_id")
    private Long id;

    @Column(name = "integration_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "detran_id", referencedColumnName = "detran_id")
    private DetranEntity detranId;

    @OneToOne
    @JoinColumn(name = "present_status_id", referencedColumnName = "status_id")
    private StatusEntity presentStatus;
}
