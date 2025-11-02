package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Response.PermissionResponse;

import java.util.List;

public interface PermissionPresenterInterface {
    List<PermissionResponse> presentList(List<DomainPermission> permissions);
    PermissionResponse present(DomainPermission permission);
}
