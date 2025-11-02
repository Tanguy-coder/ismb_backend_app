package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import org.springframework.web.multipart.MultipartFile;

public interface CreateEtudiantUseCaseInterface {
    DomainEtudiant execute(DomainEtudiant domainEtudiant, MultipartFile photoFile, Long filiereId, String statut);
}
