package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainUe;

import java.util.List;

public interface UeRepositoryInterface {
    DomainUe save(DomainUe domainUe);
    DomainUe findById(Long id);
    List<DomainUe> getAll();
    DomainUe update(Long id, DomainUe domainUe);
    void delete(Long id);
}
