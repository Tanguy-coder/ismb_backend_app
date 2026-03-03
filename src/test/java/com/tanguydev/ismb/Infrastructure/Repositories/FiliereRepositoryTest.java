package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Infrastructure.Mapper.FiliereMapper;
import com.tanguydev.ismb.Infrastructure.Models.Filiere;
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
class FiliereRepositoryTest {

    @Mock
    private FiliereJpaRepository repository;

    @Mock
    private FiliereMapper mapper;

    @InjectMocks
    private FiliereRepository filiereRepository;

    private DomainFiliere domainFiliere;
    private Filiere jpaFiliere;

    @BeforeEach
    void setUp() {
        domainFiliere = new DomainFiliere();
        domainFiliere.setLibelle("Informatique");

        jpaFiliere = new Filiere();
        jpaFiliere.setLibelle("Informatique");
    }

    @Test
    void save_ShouldThrowDuplicateResourceException_WhenLibelleExists() {
        // Given
        when(mapper.toJpa(any(DomainFiliere.class))).thenReturn(jpaFiliere);
        when(repository.existsByLibelle("Informatique")).thenReturn(true);

        // When & Then
        DuplicateResourceException exception = assertThrows(
                DuplicateResourceException.class,
                () -> filiereRepository.save(domainFiliere)
        );

        assertEquals("Filiere avec libellé='Informatique' existe déjà", exception.getMessage());
        verify(repository, never()).save(any(Filiere.class));
    }

    @Test
    void save_ShouldSaveSuccessfully_WhenLibelleDoesNotExist() {
        // Given
        when(mapper.toJpa(any(DomainFiliere.class))).thenReturn(jpaFiliere);
        when(repository.existsByLibelle("Informatique")).thenReturn(false);
        when(repository.save(any(Filiere.class))).thenReturn(jpaFiliere);
        when(mapper.toDomain(any(Filiere.class))).thenReturn(domainFiliere);

        // When
        DomainFiliere result = filiereRepository.save(domainFiliere);

        // Then
        assertNotNull(result);
        verify(repository).save(jpaFiliere);
    }

    @Test
    void update_ShouldThrowDuplicateResourceException_WhenNewLibelleExists() {
        // Given
        Filiere existingFiliere = new Filiere();
        existingFiliere.setId(1L);
        existingFiliere.setLibelle("Ancienne Filiere");

        when(repository.findById(1L)).thenReturn(Optional.of(existingFiliere));
        when(repository.existsByLibelle("Nouvelle Filiere")).thenReturn(true);

        domainFiliere.setLibelle("Nouvelle Filiere");

        // When & Then
        DuplicateResourceException exception = assertThrows(
                DuplicateResourceException.class,
                () -> filiereRepository.update(1L, domainFiliere)
        );

        assertEquals("Filiere avec libellé='Nouvelle Filiere' existe déjà", exception.getMessage());
        verify(repository, never()).save(any(Filiere.class));
    }
}
