package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Response.NiveauResponse;

import java.util.List;

public interface NiveauPresenterInterface {
    NiveauResponse present(DomainNiveau niveau);
    List<NiveauResponse> presentList(List<DomainNiveau> niveaus);
}