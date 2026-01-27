package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Response.ListClasseResponse;

import java.util.List;

public interface ListClassePresenterInterface {
    List<ListClasseResponse> present(List<DomainEtudiant> etudiants);
}
