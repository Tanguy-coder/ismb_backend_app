package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Presenter.EnseignantPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EnseignantResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.EnseignantMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnseignantPresenter implements EnseignantPresenterInterface {

    private final EnseignantMapper mapper;

    public EnseignantPresenter(EnseignantMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EnseignantResponse present(DomainEnseignant enseignant) {
        return mapper.toResponse(enseignant);
    }

    @Override
    public List<EnseignantResponse> presentList(List<DomainEnseignant> enseignants) {
        return mapper.toResponseList(enseignants);
    }
}
