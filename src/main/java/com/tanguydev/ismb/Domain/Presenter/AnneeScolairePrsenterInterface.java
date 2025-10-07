package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Response.AnneeScolaireResponse;

import java.util.List;

public interface AnneeScolairePrsenterInterface {
    public AnneeScolaireResponse present(DomainAnneeScolaire domainAnneeScolaire);
    public List<AnneeScolaireResponse> presentList(List<DomainAnneeScolaire> domainAnneeScolaires);
}
