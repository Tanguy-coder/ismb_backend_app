package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Presenter.AnneeScolairePrsenterInterface;
import com.tanguydev.ismb.Domain.Response.AnneeScolaireResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.AnneeScolaireMapper;

import java.util.List;

public class AnneeScolairePresenter implements AnneeScolairePrsenterInterface {
    private final AnneeScolaireMapper mapper;

    public AnneeScolairePresenter(AnneeScolaireMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AnneeScolaireResponse present(DomainAnneeScolaire domainAnneeScolaire) {
        return mapper.toJpaResponse(domainAnneeScolaire);
    }

    @Override
    public List<AnneeScolaireResponse> presentList(List<DomainAnneeScolaire> domainAnneeScolaires) {
        return mapper.toJpaResponseList(domainAnneeScolaires);
    }
}
