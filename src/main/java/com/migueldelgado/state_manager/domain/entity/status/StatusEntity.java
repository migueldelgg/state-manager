package com.migueldelgado.state_manager.domain.entity.status;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_type")
    private StatusEnum type;

    @Column(name = "error_description")
    private String errorDescription;

    @CreationTimestamp
    private Instant creationTimestamp;
}
