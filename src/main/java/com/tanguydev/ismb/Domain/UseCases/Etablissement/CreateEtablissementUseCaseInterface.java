package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import org.springframework.web.multipart.MultipartFile;

public interface CreateEtablissementUseCaseInterface {
    DomainEtablissement execute(DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile);
}
