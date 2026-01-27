package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import org.springframework.web.multipart.MultipartFile;

public interface UpdateEtablissementUseCaseInterface {
    DomainEtablissement execute(Long id, DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile);
}
