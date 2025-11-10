package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Response.UeResponse;

import java.util.List;

public interface UePresenterInterface {
    UeResponse present(DomainUe domainUe);
    List<UeResponse> presentList(List<DomainUe> domainUes);
}
