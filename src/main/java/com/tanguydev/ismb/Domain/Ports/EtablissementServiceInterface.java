package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EtablissementServiceInterface {
    DomainEtablissement save(DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile);
    DomainEtablissement findById(Long id);
    List<DomainEtablissement> getAll();
    DomainEtablissement update(Long id, DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile);
}
