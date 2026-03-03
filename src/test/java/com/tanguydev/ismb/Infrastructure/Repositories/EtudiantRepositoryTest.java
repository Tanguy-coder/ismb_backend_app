package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import com.tanguydev.ismb.Infrastructure.Models.Etudiant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EtudiantRepositoryTest {

    @Mock
    private EtudiantJpaRepository repository;

    @Mock
    private EtudiantMapper mapper;

    @InjectMocks
    private EtudiantRepository etudiantRepository;

    private DomainEtudiant domainEtudiant;
    private Etudiant jpaEtudiant;

    @BeforeEach
    void setUp() {
        domainEtudiant = new DomainEtudiant();
        domainEtudiant.setMatricule("ETU20261");

        jpaEtudiant = new Etudiant();
        jpaEtudiant.setMatricule("ETU20261");
    }

    @Test
    void save_ShouldThrowDuplicateResourceException_WhenMatriculeExists() {
        // Given
        when(mapper.toJpa(any(DomainEtudiant.class), any(CycleAvoidingMappingContext.class)))
                .thenReturn(jpaEtudiant);
        when(repository.existsByMatricule("ETU20261")).thenReturn(true);

        // When & Then
        DuplicateResourceException exception = assertThrows(
                DuplicateResourceException.class,
                () -> etudiantRepository.save(domainEtudiant)
        );

        assertEquals("Etudiant avec matricule='ETU20261' existe déjà", exception.getMessage());
        verify(repository, never()).save(any(Etudiant.class));
    }

    @Test
    void save_ShouldGenerateMatricule_WhenMatriculeIsNull() {
        // Given
        jpaEtudiant.setMatricule(null);
        domainEtudiant.setMatricule(null);
        
        when(mapper.toJpa(any(DomainEtudiant.class), any(CycleAvoidingMappingContext.class)))
                .thenReturn(jpaEtudiant);
        when(repository.existsByMatricule(anyString())).thenReturn(false);
        when(repository.save(any(Etudiant.class))).thenReturn(jpaEtudiant);
        when(mapper.toDomain(any(Etudiant.class), any(CycleAvoidingMappingContext.class)))
                .thenReturn(domainEtudiant);

        // When
        DomainEtudiant result = etudiantRepository.save(domainEtudiant);

        // Then
        assertNotNull(result);
        verify(repository).save(any(Etudiant.class));
    }

    @Test
    void save_ShouldSaveSuccessfully_WhenMatriculeDoesNotExist() {
        // Given
        when(mapper.toJpa(any(DomainEtudiant.class), any(CycleAvoidingMappingContext.class)))
                .thenReturn(jpaEtudiant);
        when(repository.existsByMatricule("ETU20261")).thenReturn(false);
        when(repository.save(any(Etudiant.class))).thenReturn(jpaEtudiant);
        when(mapper.toDomain(any(Etudiant.class), any(CycleAvoidingMappingContext.class)))
                .thenReturn(domainEtudiant);

        // When
        DomainEtudiant result = etudiantRepository.save(domainEtudiant);

        // Then
        assertNotNull(result);
        verify(repository).save(jpaEtudiant);
    }
}
