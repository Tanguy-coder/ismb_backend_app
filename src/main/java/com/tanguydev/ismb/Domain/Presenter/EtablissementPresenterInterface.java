package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Response.EtablissementResponse;

import java.util.List;

public interface EtablissementPresenterInterface {
    EtablissementResponse present(DomainEtablissement etablissement);
    List<EtablissementResponse> presentList(List<DomainEtablissement> etablissements);
}
