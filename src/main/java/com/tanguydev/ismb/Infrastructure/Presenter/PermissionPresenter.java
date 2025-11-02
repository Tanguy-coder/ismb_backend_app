package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Presenter.PermissionPresenterInterface;
import com.tanguydev.ismb.Domain.Response.PermissionResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.PermissionMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionPresenter implements PermissionPresenterInterface {

    private final PermissionMapper permissionMapper;

    public PermissionPresenter(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<PermissionResponse> presentList(List<DomainPermission> permissions) {
        return permissionMapper.toResponseList(permissions);
    }

    @Override
    public PermissionResponse present(DomainPermission permission) {
        return permissionMapper.toResponse(permission);
    }
}
