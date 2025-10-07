package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Response.EtudiantResponse;
import com.tanguydev.ismb.Infrastructure.Models.Etudiant;
import com.tanguydev.ismb.Infrastructure.Models.Niveau;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "niveau.id", target = "niveau.id")
    Etudiant toJpa(DomainEtudiant etudiant);

    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "niveau.id", target = "niveau.id")
    DomainEtudiant toDomain(Etudiant etudiant);

    List<Etudiant> toJpaList(List<DomainEtudiant> etudiants);
    List<DomainEtudiant> toDomainList(List<Etudiant> etudiants);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "niveau.id", target = "niveauId")
    EtudiantResponse toResponse(DomainEtudiant etudiant);

    List<EtudiantResponse> toResponseList(List<DomainEtudiant> etudiants);

    // Helper methods for mapping IDs to entities
    default User map(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }

    default Niveau mapNiveau(Long niveauId) {
        if (niveauId == null) {
            return null;
        }
        Niveau niveau = new Niveau();
        niveau.setId(niveauId);
        return niveau;
    }

    // Helper methods for mapping entities to IDs
    default Long map(User user) {
        return user != null ? user.getId() : null;
    }

    default Long map(Niveau niveau) {
        return niveau != null ? niveau.getId() : null;
    }
}
