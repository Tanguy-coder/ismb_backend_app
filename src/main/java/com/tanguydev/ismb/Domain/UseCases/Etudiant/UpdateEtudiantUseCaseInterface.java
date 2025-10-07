package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import org.springframework.web.multipart.MultipartFile;

public interface UpdateEtudiantUseCaseInterface {
    DomainEtudiant execute(Long id, DomainEtudiant domainEtudiant, MultipartFile photoFile);
}
