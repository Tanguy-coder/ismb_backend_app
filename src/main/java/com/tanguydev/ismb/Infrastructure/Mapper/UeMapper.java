package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Response.UeResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Ue;
import com.tanguydev.ismb.Infrastructure.Request.UeRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FiliereMapper.class, MatiereMapper.class, EnseignantMapper.class, AnneeScolaireMapper.class})
public interface UeMapper {

    // Break circular dependency with NoteMapper by ignoring notes here; Note mapping can be handled separately when needed
    @Mapping(source = "credits", target = "credits")
    @Mapping(target = "notes", ignore = true)
    Ue toJpa(DomainUe domainUe, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "credits", target = "credits")
    @Mapping(target = "notes", ignore = true)
    DomainUe toDomain(Ue ue, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "matiere.id", target = "matiere.id")
    @Mapping(source = "enseignant.id", target = "enseignant.id")
    @Mapping(source = "anneeScolaire.id", target = "anneeScolaire.id")
    @Mapping(source = "filiere.id", target = "filiere.id")
    @Mapping(source = "credits", target = "credits")
    DomainUe toDomain(UeRequest ueRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "credits", target = "credits")
    @Mapping(target = "notes", ignore = true)
    UeResponse toResponse(DomainUe domainUe);
}
