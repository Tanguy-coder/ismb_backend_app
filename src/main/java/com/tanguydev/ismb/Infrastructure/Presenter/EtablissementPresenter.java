package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Presenter.EtablissementPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EtablissementResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.EtablissementMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtablissementPresenter implements EtablissementPresenterInterface {

    private final EtablissementMapper mapper;

    public EtablissementPresenter(EtablissementMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EtablissementResponse present(DomainEtablissement etablissement) {
        return mapper.toResponse(etablissement);
    }

    @Override
    public List<EtablissementResponse> presentList(List<DomainEtablissement> etablissements) {
        return mapper.toResponseList(etablissements);
    }
}
