package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EtudiantServiceInterface {
    DomainEtudiant save(DomainEtudiant domainEtudiant, MultipartFile photoFile, Long filiereId, String statut);
    DomainEtudiant findById(Long id);
    List<DomainEtudiant> getAll();
    DomainEtudiant update(Long id, DomainEtudiant domainEtudiant, MultipartFile photoFile);

    void delete(Long id);
}
