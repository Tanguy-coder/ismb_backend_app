package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Presenter.ListClassePresenterInterface;
import com.tanguydev.ismb.Domain.Response.ListClasseResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.ParcourtMapper;

import java.util.List;

public class ListClassePresenter implements ListClassePresenterInterface {
    private final ParcourtMapper mapper;

    public ListClassePresenter(ParcourtMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ListClasseResponse> present(List<DomainEtudiant> etudiants) {
        return mapper.toResponseList(etudiants);
    }
}
