package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;



import java.util.List;



public interface EtudiantRepositoryInterface {

    DomainEtudiant save(DomainEtudiant domainEtudiant);

    DomainEtudiant findById(Long id);

    List<DomainEtudiant> getAll();

    DomainEtudiant update(Long id, DomainEtudiant domainEtudiant);

    void delete(Long id);



}


