package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

public interface UpdateUserUseCaseInterface {
    DomainUser execute(Long id, DomainUser user);
}
