package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toJpa(DomainUser user);

    @Mapping(target = "roles", ignore = true)
    DomainUser toDomain(User user);

    List<User> toJpaList(List<DomainUser> users);
    List<DomainUser> toDomainList(List<User> users);
}
