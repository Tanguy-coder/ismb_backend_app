package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Presenter.NiveauPresenterInterface;
import com.tanguydev.ismb.Domain.Response.NiveauResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.NiveauMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NiveauPresenter implements NiveauPresenterInterface {
    private final NiveauMapper mapper;

    public NiveauPresenter(NiveauMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public NiveauResponse present(DomainNiveau niveau) {
        return mapper.toResponse(niveau);
    }

    @Override
    public List<NiveauResponse> presentList(List<DomainNiveau> niveaus) {
        return mapper.toResponseList(niveaus);
    }
}
