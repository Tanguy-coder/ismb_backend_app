package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Presenter.EtudiantPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EtudiantResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtudiantPresenter implements EtudiantPresenterInterface {

    private final EtudiantMapper mapper;

    public EtudiantPresenter(EtudiantMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EtudiantResponse present(DomainEtudiant etudiant) {
        return mapper.toResponse(etudiant);
    }

    @Override
    public List<EtudiantResponse> presentList(List<DomainEtudiant> etudiants) {
        return mapper.toResponseList(etudiants);
    }
}
