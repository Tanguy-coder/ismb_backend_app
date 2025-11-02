package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Presenter.RolePresenterInterface;
import com.tanguydev.ismb.Domain.Response.RoleResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolePresenter implements RolePresenterInterface {

    private final RoleMapper roleMapper;

    public RolePresenter(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleResponse> presentList(List<DomainRole> roles) {
        return roleMapper.toResponseList(roles);
    }

    @Override
    public RoleResponse present(DomainRole role) {
        return roleMapper.toResponse(role);
    }
}
