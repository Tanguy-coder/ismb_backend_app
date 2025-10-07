package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Gateway.EtablissementRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;
import com.tanguydev.ismb.Domain.Ports.FileStorageServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EtablissementService implements EtablissementServiceInterface {
    private final EtablissementRepositoryInterface repository;
    private final FileStorageServiceInterface fileStorageService;

    public EtablissementService(EtablissementRepositoryInterface repository, FileStorageServiceInterface fileStorageService) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public DomainEtablissement save(DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile) {
        String logoFileName = fileStorageService.save(logoFile);
        String imageFileName = fileStorageService.save(imageFile);

        domainEtablissement.setLogo(logoFileName);
        domainEtablissement.setImage(imageFileName);

        return this.repository.save(domainEtablissement);
    }

    @Override
    public DomainEtablissement findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<DomainEtablissement> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DomainEtablissement update(Long id, DomainEtablissement domainEtablissement) {
        // TODO: Implement file update logic
        return this.repository.update(id, domainEtablissement);
    }
}
