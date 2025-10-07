package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Gateway.EtudiantRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;
import com.tanguydev.ismb.Domain.Ports.FileStorageServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EtudiantService implements EtudiantServiceInterface {
    private final EtudiantRepositoryInterface repository;
    private final FileStorageServiceInterface fileStorageService;

    public EtudiantService(EtudiantRepositoryInterface repository, FileStorageServiceInterface fileStorageService) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public DomainEtudiant save(DomainEtudiant domainEtudiant, MultipartFile photoFile) {
        String photoFileName = fileStorageService.save(photoFile);
        domainEtudiant.setPhoto(photoFileName);
        return this.repository.save(domainEtudiant);
    }

    @Override
    public DomainEtudiant findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<DomainEtudiant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DomainEtudiant update(Long id, DomainEtudiant domainEtudiant, MultipartFile photoFile) {
        // Retrieve existing student to handle photo update
        DomainEtudiant existingEtudiant = this.repository.findById(id);

        // Handle photo update
        if (photoFile != null && !photoFile.isEmpty()) {
            String photoFileName = fileStorageService.save(photoFile);
            domainEtudiant.setPhoto(photoFileName);
        } else {
            // If no new photo is provided, retain the old one
            domainEtudiant.setPhoto(existingEtudiant.getPhoto());
        }

        return this.repository.update(id, domainEtudiant);
    }
}
