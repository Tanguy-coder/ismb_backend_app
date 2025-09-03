package com.tanguydev.ismb.Domain.UseCases;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

public interface CreateUserUseCaseInterface {
    DomainUser execute(DomainUser user);
}
