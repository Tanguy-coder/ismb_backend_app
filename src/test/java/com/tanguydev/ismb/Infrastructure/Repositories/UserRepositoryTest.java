package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Infrastructure.Mapper.UserMapper;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserRepositoryJpaInterface repository;

    @Mock
    private UserMapper mapper;

    @Mock
    private RoleJpaRepository roleJpaRepository;

    @InjectMocks
    private UserRepository userRepository;

    private DomainUser domainUser;
    private User jpaUser;

    @BeforeEach
    void setUp() {
        domainUser = new DomainUser();
        domainUser.setUsername("testuser");
        domainUser.setEmail("test@example.com");

        jpaUser = new User();
        jpaUser.setUsername("testuser");
        jpaUser.setEmail("test@example.com");
    }

    @Test
    void save_ShouldThrowDuplicateResourceException_WhenUsernameExists() {
        // Given
        when(mapper.toJpa(any(DomainUser.class))).thenReturn(jpaUser);
        when(repository.findByUsername("testuser")).thenReturn(Optional.of(jpaUser));

        // When & Then
        DuplicateResourceException exception = assertThrows(
                DuplicateResourceException.class,
                () -> userRepository.save(domainUser)
        );

        assertEquals("User avec username='testuser' existe déjà", exception.getMessage());
        verify(repository, never()).save(any(User.class));
    }

    @Test
    void save_ShouldThrowDuplicateResourceException_WhenEmailExists() {
        // Given
        when(mapper.toJpa(any(DomainUser.class))).thenReturn(jpaUser);
        when(repository.findByUsername("testuser")).thenReturn(Optional.empty());
        when(repository.findByUsernameOrEmail("", "test@example.com")).thenReturn(Optional.of(jpaUser));

        // When & Then
        DuplicateResourceException exception = assertThrows(
                DuplicateResourceException.class,
                () -> userRepository.save(domainUser)
        );

        assertEquals("User avec email='test@example.com' existe déjà", exception.getMessage());
        verify(repository, never()).save(any(User.class));
    }

    @Test
    void save_ShouldSaveSuccessfully_WhenUserDoesNotExist() {
        // Given
        when(mapper.toJpa(any(DomainUser.class))).thenReturn(jpaUser);
        when(repository.findByUsername("testuser")).thenReturn(Optional.empty());
        when(repository.findByUsernameOrEmail("", "test@example.com")).thenReturn(Optional.empty());
        when(repository.save(any(User.class))).thenReturn(jpaUser);
        when(mapper.toDomain(any(User.class))).thenReturn(domainUser);

        // When
        DomainUser result = userRepository.save(domainUser);

        // Then
        assertNotNull(result);
        verify(repository).save(jpaUser);
    }
}
