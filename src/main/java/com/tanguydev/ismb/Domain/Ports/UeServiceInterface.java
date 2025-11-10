package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainUe;

import java.util.List;

public interface UeServiceInterface {
    DomainUe save(DomainUe domainUe, Long matiereId, Long enseignantId, Long anneeScolaireId, Long filiereId);
    DomainUe findById(Long id);
    List<DomainUe> getAll();
    DomainUe update(Long id, DomainUe domainUe, Long matiereId, Long enseignantId, Long anneeScolaireId, Long filiereId);
    void delete(Long id);
}
