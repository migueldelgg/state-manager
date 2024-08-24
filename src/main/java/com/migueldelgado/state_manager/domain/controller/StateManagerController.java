package com.migueldelgado.state_manager.domain.controller;

import com.migueldelgado.state_manager.domain.entity.detran.UFEnum;
import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import com.migueldelgado.state_manager.domain.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateManagerController {

    private StateRepository stateRepository;
    private IntegrationRepository integrationRepository;
    private DetranRepository detranRepository;
    private StatusRepository statusRepository;
    private StatusHistoryRepository statusHistoryRepository;


    @PostMapping("/all")
    public ResponseEntity<Object> all(@RequestBody String stateName, String uf) {

        var state = new StateEntity();
        state.setName(stateName);

        for () {

        state.setUf(UFEnum.valueOf(uf));

        stateRepository.save(state);

        return ResponseEntity.ok(state);
    }

}
