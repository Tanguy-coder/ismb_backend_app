package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Response.MatiereResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Matiere;
import com.tanguydev.ismb.Infrastructure.Request.MatiereRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {NiveauMapper.class})
public interface MatiereMapper {

    Matiere toJpa(DomainMatiere domainMatiere, @Context CycleAvoidingMappingContext context);

    DomainMatiere toDomain(Matiere matiere, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "niveaux", ignore = true) // Niveaux will be handled by the service layer
    DomainMatiere toDomain(MatiereRequest matiereRequest);

    @Mapping(source = "niveaux", target = "niveaux")
    MatiereResponse toResponse(DomainMatiere domainMatiere);

    Set<MatiereResponse> toResponseSet(Set<DomainMatiere> domainMatieres);
}
