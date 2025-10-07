package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Response.FiliereResponse;

import java.util.List;

public interface FilierePresenterInterface {
    FiliereResponse present(DomainFiliere filiere);
    List<FiliereResponse> presentList(List<DomainFiliere> filieres);
}