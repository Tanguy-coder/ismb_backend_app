package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;

import java.util.List;


public interface NiveauServiceInterface {
    DomainNiveau save(DomainNiveau niveau);
    List<DomainNiveau> getAll();
    DomainNiveau findById(Long id);
    DomainNiveau update(Long id, DomainNiveau niveau);
}
