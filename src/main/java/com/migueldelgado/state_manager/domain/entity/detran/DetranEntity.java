package com.migueldelgado.state_manager.domain.entity.detran;

import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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
}
