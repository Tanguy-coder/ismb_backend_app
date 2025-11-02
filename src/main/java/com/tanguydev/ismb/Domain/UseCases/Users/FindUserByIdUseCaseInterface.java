package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

public interface FindUserByIdUseCaseInterface {
    DomainUser execute(Long id);
}
