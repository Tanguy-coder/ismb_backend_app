package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Response.MatiereResponse;

import java.util.List;

public interface MatierePresenterInterface {
    MatiereResponse present(DomainMatiere matiere);
    List<MatiereResponse> presentList(List<DomainMatiere> matieres);
}
