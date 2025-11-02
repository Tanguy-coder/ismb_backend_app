package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Presenter.UserPresenterInterface;
import com.tanguydev.ismb.Domain.Response.UserResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPresenter implements UserPresenterInterface {

    private final UserMapper userMapper;

    public UserPresenter(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse present(DomainUser user) {
        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> presentList(List<DomainUser> users) {
        return userMapper.toResponseList(users);
    }
}
