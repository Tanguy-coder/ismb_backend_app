package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Response.EnseignantResponse;

import java.util.List;

public interface EnseignantPresenterInterface {
    EnseignantResponse present(DomainEnseignant enseignant);
    List<EnseignantResponse> presentList(List<DomainEnseignant> enseignants);
}
