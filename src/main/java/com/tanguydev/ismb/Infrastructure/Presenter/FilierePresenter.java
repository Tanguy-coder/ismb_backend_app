package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Presenter.FilierePresenterInterface;
import com.tanguydev.ismb.Domain.Response.FiliereResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.FiliereMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilierePresenter implements FilierePresenterInterface {

    private final FiliereMapper mapper;

    public FilierePresenter(FiliereMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public FiliereResponse present(DomainFiliere filiere) {
        return mapper.toResponse(filiere);
    }

    @Override
    public List<FiliereResponse> presentList(List<DomainFiliere> filieres) {
        return mapper.toResponseList(filieres);
    }
}