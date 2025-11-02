package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Response.UserResponse;

import java.util.List;

public interface UserPresenterInterface {
    UserResponse present(DomainUser user);
    List<UserResponse> presentList(List<DomainUser> users);
}
