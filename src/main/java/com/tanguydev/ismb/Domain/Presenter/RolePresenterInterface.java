package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Response.RoleResponse;

import java.util.List;

public interface RolePresenterInterface {
    List<RoleResponse> presentList(List<DomainRole> roles);
    RoleResponse present(DomainRole role);
}
