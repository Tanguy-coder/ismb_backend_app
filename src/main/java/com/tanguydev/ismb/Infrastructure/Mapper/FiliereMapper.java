package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Response.FiliereResponse;
import com.tanguydev.ismb.Infrastructure.Models.Filiere;
import com.tanguydev.ismb.Infrastructure.Models.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FiliereMapper {

    @Mapping(source = "niveau.id", target = "niveau.id")
    Filiere toJpa(DomainFiliere filiere);

    @Mapping(source = "niveau.id", target = "niveau.id")
    DomainFiliere toDomain(Filiere filiere);

    List<Filiere> toJpaList(List<DomainFiliere> filieres);
    List<DomainFiliere> toDomainList (List<Filiere> filieres);

    @Mapping(source = "niveau.id", target = "niveauId")
    FiliereResponse toResponse(DomainFiliere filiere);
    List<FiliereResponse> toResponseList(List<DomainFiliere> filieres);

    // Helper methods for mapping IDs to entities
    default Niveau mapNiveau(Long niveauId) {
        if (niveauId == null) {
            return null;
        }
        Niveau niveau = new Niveau();
        niveau.setId(niveauId);
        return niveau;
    }

    // Helper methods for mapping entities to IDs
    default Long map(Niveau niveau) {
        return niveau != null ? niveau.getId() : null;
    }
}
