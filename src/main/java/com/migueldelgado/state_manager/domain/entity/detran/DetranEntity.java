package com.migueldelgado.state_manager.domain.entity.detran;

import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import com.migueldelgado.state_manager.domain.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_detran")
public class DetranEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detran_id")
    private Long id;

    @Column(name = "detran_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_uf", referencedColumnName = "state_uf")
    private StateEntity state;

    @ManyToOne
    @JoinColumn(name = "criado_por", referencedColumnName = "user_id")
    private UserEntity createdBy;
}
