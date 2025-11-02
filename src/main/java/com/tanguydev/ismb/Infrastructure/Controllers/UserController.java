package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Presenter.UserPresenterInterface;
import com.tanguydev.ismb.Domain.Response.UserResponse;
import com.tanguydev.ismb.Domain.UseCases.Users.*;
import com.tanguydev.ismb.Infrastructure.Mapper.UserMapper;
import com.tanguydev.ismb.Infrastructure.Request.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCaseInterface createUserUseCase;
    private final ListUsersUseCaseInterface listUsersUseCase;
    private final FindUserByIdUseCaseInterface findUserByIdUseCase;
    private final UpdateUserUseCaseInterface updateUserUseCase;
    private final UserMapper userMapper;
    private final UserPresenterInterface userPresenter;

    public UserController(CreateUserUseCaseInterface createUserUseCase,
                          ListUsersUseCaseInterface listUsersUseCase,
                          FindUserByIdUseCaseInterface findUserByIdUseCase,
                          UpdateUserUseCaseInterface updateUserUseCase,
                          UserMapper userMapper,
                          UserPresenterInterface userPresenter) {
        this.createUserUseCase = createUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.userMapper = userMapper;
        this.userPresenter = userPresenter;
    }

    @GetMapping("/me")
    public String me() {
        return "OK (token valide)";
    }

    @GetMapping("/admin-only")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() { return "ADMIN OK"; }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest);
        DomainUser domainUser = userMapper.toDomain(userRequest);
        System.out.println("Après mapping"+domainUser);
        DomainUser createdUser = createUserUseCase.execute(domainUser);
        return new ResponseEntity<>(userPresenter.present(createdUser), HttpStatus.CREATED);
    }

    @GetMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<DomainUser> domainUsers = listUsersUseCase.execute();
        //System.out.println(domainUsers);
        return ResponseEntity.ok(userPresenter.presentList(domainUsers));
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        DomainUser domainUser = findUserByIdUseCase.execute(id);
        if (domainUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userPresenter.present(domainUser));
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        DomainUser domainUser = userMapper.toDomain(userRequest);
        DomainUser updatedUser = updateUserUseCase.execute(id, domainUser);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userPresenter.present(updatedUser));
    }
}
