package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EnseignantServiceInterface {
    DomainEnseignant save(DomainEnseignant domainEnseignant, MultipartFile photoFile);
    DomainEnseignant findById(Long id);
    List<DomainEnseignant> getAll();
    DomainEnseignant update(Long id, DomainEnseignant domainEnseignant, MultipartFile photoFile);
    void delete(Long id);
}

