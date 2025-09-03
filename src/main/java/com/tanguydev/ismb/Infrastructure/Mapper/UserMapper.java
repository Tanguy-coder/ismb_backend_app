package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toJpa(DomainUser user);
    DomainUser toDomain(User user);
    List<User> toJpaList(List<DomainUser> users);
    List<DomainUser> toDomainList(List<User> users);
}
