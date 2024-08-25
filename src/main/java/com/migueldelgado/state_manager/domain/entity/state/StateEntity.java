package com.migueldelgado.state_manager.domain.entity.state;

import com.migueldelgado.state_manager.domain.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_state")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long id;

    @Column(name = "state_uf", unique = true)
    @Enumerated(EnumType.STRING)
    private UFEnum uf;

    @ManyToOne
    @JoinColumn(name = "criado_por", referencedColumnName = "user_id")
    private UserEntity criadoPor;
}
