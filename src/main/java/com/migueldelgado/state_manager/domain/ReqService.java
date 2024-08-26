package com.migueldelgado.state_manager.domain;

import com.migueldelgado.state_manager.domain.entity.StatusHistoryEntity;
import com.migueldelgado.state_manager.domain.entity.detran.DetranEntity;
import com.migueldelgado.state_manager.domain.entity.integration.IntegrationEntity;
import com.migueldelgado.state_manager.domain.entity.state.StateEntity;
import com.migueldelgado.state_manager.domain.entity.state.UFEnum;
import com.migueldelgado.state_manager.domain.entity.status.StatusEntity;
import com.migueldelgado.state_manager.domain.entity.status.StatusEnum;
import com.migueldelgado.state_manager.domain.repository.*;
import com.migueldelgado.state_manager.domain.useCase.CreateStateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ReqService {

    @Autowired
    private CreateStateUseCase createStateUseCase;

    @Autowired
    private DetranRepository detranRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private IntegrationRepository integrationRepository;

    @Autowired
    private StatusHistoryRepository statusHistoryRepository;

    @Autowired
    private StateRepository stateRepository;

    public StateEntity createState(){
        var newState = new StateEntity();
        newState.setUf(UFEnum.valueOf("MG"));
        stateRepository.save(newState);

        return newState;
    }

    public DetranEntity createDetran(){
        var newDetran = new DetranEntity();
        newDetran.setName("Detran-MG");
        newDetran.setState(createState());
        detranRepository.save(newDetran);

        return newDetran;
    }

    public void execute(){

        var status = new StatusEntity();
        status.setType(StatusEnum.OPERATIONAL);
        status.setErrorDescription("Funcionando.");
        statusRepository.save(status);
        // um status tem uma pertence a uma integracao -> status historico

        var integration = new IntegrationEntity();
        integration.setName("Korreta IPVA e Multas");
        integration.setPresentStatus(status);
        integration.setDetranId(createDetran());
        integrationRepository.save(integration);

        var historicoStatus = new StatusHistoryEntity();
        historicoStatus.setIntegration(integration);
        historicoStatus.setStatus(status);
        historicoStatus.setChangeTimestamp(Instant.now());
        statusHistoryRepository.save(historicoStatus);
    }

    public List<IntegrationEntity> getIntegrations(){
        return integrationRepository.findAll();
    }

}
