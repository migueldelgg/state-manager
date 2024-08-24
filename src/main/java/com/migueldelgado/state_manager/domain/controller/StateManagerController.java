package com.migueldelgado.state_manager.domain.controller;

import com.migueldelgado.state_manager.domain.entity.state.StateRequestBody;
import com.migueldelgado.state_manager.domain.useCase.CreateStateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StateManagerController {

    @Autowired
    private CreateStateUseCase createStateUseCase;

    @PostMapping("/create-state")
    public ResponseEntity<Object> createState(@RequestBody StateRequestBody req) {

        var state = createStateUseCase.execute(req);

        var response = new HashMap<String, String>();
        response.put("msg", "Aconteceu algo de errrado. Verifique os dados enviados");

        return state.<ResponseEntity<Object>>map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).body(response));
    }

}
