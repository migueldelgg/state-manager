package com.migueldelgado.state_manager.domain.entity.user;

import com.migueldelgado.state_manager.domain.entity.detran.DetranEntity;
import com.migueldelgado.state_manager.domain.entity.integration.IntegrationEntity;
import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import com.migueldelgado.state_manager.domain.entity.status.StatusEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(unique = true)
    @Email
    private String email;
    private String password;

    @OneToMany(mappedBy = "criadoPor")
    private List<IntegrationEntity> integrations;

    @OneToMany(mappedBy = "criadoPor")
    private List<StatusEntity> statuses;

    @OneToMany(mappedBy = "criadoPor")
    private List<DetranEntity> detrans;

    @OneToMany(mappedBy = "criadoPor")
    private List<StateEntity> states;

    /*public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {

        return passwordEncoder.matches(loginRequest.password(), this.password);
    }*/
}
