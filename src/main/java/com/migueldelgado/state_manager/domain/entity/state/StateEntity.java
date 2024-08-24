package com.migueldelgado.state_manager.domain.entity.state;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long id;

    @Column(name = "state_uf", unique = true)
    @Enumerated(EnumType.STRING)
    private UFEnum uf;
}
