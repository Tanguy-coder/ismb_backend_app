package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Presenter.MatierePresenterInterface;
import com.tanguydev.ismb.Domain.Response.MatiereResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.MatiereMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatierePresenter implements MatierePresenterInterface {

    private final MatiereMapper mapper;

    public MatierePresenter(MatiereMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MatiereResponse present(DomainMatiere matiere) {
        return mapper.toResponse(matiere);
    }

    @Override
    public List<MatiereResponse> presentList(List<DomainMatiere> matieres) {
        return matieres.stream().map(this::present).collect(Collectors.toList());
    }
}
