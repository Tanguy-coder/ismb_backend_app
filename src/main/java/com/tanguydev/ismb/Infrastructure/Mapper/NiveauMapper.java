package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Response.NiveauResponse;
import com.tanguydev.ismb.Infrastructure.Models.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NiveauMapper {

    @Mapping(source = "libelle", target = "libelle")
    Niveau toJpa(DomainNiveau niveau);

    @Mapping(source = "libelle", target = "libelle")
    @Mapping(target = "filieres", ignore = true)
    @Mapping(target = "ues", ignore = true)
    @Mapping(target = "parcours", ignore = true)
    @Mapping(target = "matieres", ignore = true)
    DomainNiveau toDomain(Niveau niveau);

    List<Niveau> toJpaList(List<DomainNiveau> niveaus);
    List<DomainNiveau> toDomainList (List<Niveau> niveaus);

    @Mapping(source = "libelle", target = "libelle")
    NiveauResponse toResponse(DomainNiveau niveau);
    List<NiveauResponse> toResponseList(List<DomainNiveau> niveaus);
}
