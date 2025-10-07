package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Response.EtudiantResponse;

import java.util.List;

public interface EtudiantPresenterInterface {
    EtudiantResponse present(DomainEtudiant etudiant);
    List<EtudiantResponse> presentList(List<DomainEtudiant> etudiants);
}
