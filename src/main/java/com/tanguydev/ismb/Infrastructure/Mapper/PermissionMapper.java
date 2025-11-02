package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Response.PermissionResponse;
import com.tanguydev.ismb.Infrastructure.Models.Permission;
import com.tanguydev.ismb.Infrastructure.Request.PermissionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    DomainPermission toDomain(PermissionRequest request);
    Permission toModel(DomainPermission domainPermission);
    DomainPermission toDomain(Permission permission);
    PermissionResponse toResponse(DomainPermission domainPermission);
    List<PermissionResponse> toResponseList(List<DomainPermission> domainPermissions);
    void updateDomainFromRequest(PermissionRequest request, @MappingTarget DomainPermission domainPermission);
}
