package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Response.UserResponse;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import com.tanguydev.ismb.Infrastructure.Models.User;
import com.tanguydev.ismb.Infrastructure.Request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    User toJpa(DomainUser user);

    DomainUser toDomain(User user);

    List<User> toJpaList(List<DomainUser> users);

    List<DomainUser> toDomainList(List<User> users);

    @Mapping(target = "roles", source = "roles")
    DomainUser toDomain(UserRequest userRequest);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapDomainRolesToStrings")
    UserResponse toResponse(DomainUser domainUser);

    List<UserResponse> toResponseList(List<DomainUser> domainUsers);

    Set<Role> toJpa(Set<DomainRole> domainRoles);

    @Named("mapDomainRolesToStrings")
    default Set<String> mapDomainRolesToStrings(Set<DomainRole> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream()
                .map(role -> role.getName().toString())
                .collect(Collectors.toSet());
    }
}