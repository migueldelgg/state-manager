package com.migueldelgado.state_manager.domain.useCase;

import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import com.migueldelgado.state_manager.domain.entity.state.StateRequestBody;
import com.migueldelgado.state_manager.domain.entity.state.StateResponseBody;
import com.migueldelgado.state_manager.domain.entity.state.UFEnum;
import com.migueldelgado.state_manager.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateStateUseCase {

    @Autowired
    private StateRepository stateRepository;

    public Optional<StateResponseBody> execute(StateRequestBody req) {
        try {
            var state = new StateEntity();
            state.setUf(UFEnum.valueOf(req.uf().toUpperCase()));

            if(stateRepository.findByUf(state.getUf()).isPresent() || !isValid(req)){
                return Optional.empty();
            }

            stateRepository.save(state);

            return Optional.of(new StateResponseBody(state, "Estado criado com sucesso"));
        }catch (IllegalArgumentException e){
            return Optional.empty();
        }
    }

    public boolean isValid(StateRequestBody req){
        return !req.uf().isBlank() &&
                req.uf().length() == 2 &&
                !req.name().isBlank() &&
                req.name().length() >= 2 &&
                req.name().length() <= 20;
    }
}
