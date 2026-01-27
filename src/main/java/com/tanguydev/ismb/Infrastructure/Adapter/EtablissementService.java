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
    public DomainEtablissement update(Long id, DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile) {
        // Récupérer l'établissement existant pour préserver les fichiers si non fournis
        DomainEtablissement existing = this.repository.findById(id);
        
        // Sauvegarder les nouveaux fichiers seulement s'ils sont fournis
        if (logoFile != null && !logoFile.isEmpty()) {
            String logoFileName = fileStorageService.save(logoFile);
            domainEtablissement.setLogo(logoFileName);
        } else {
            // Conserver le logo existant
            domainEtablissement.setLogo(existing.getLogo());
        }
        
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageFileName = fileStorageService.save(imageFile);
            domainEtablissement.setImage(imageFileName);
        } else {
            // Conserver l'image existante
            domainEtablissement.setImage(existing.getImage());
        }
        
        return this.repository.update(id, domainEtablissement);
    }
}
