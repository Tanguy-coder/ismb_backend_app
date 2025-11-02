package com.tanguydev.ismb.Infrastructure.Request;

import lombok.Data;

@Data
public class RolePermissionRequest {
    private Long roleId;
    private Long permissionId;
}
