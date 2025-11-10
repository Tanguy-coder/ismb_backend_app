package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Response.UeResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Ue;
import com.tanguydev.ismb.Infrastructure.Request.UeRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FiliereMapper.class, NoteMapper.class, MatiereMapper.class, EnseignantMapper.class, AnneeScolaireMapper.class})
public interface UeMapper {

    @Mapping(source = "credits", target = "credits")
    Ue toJpa(DomainUe domainUe, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "credits", target = "credits")
    DomainUe toDomain(Ue ue, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "matiere.id", target = "matiere.id")
    @Mapping(source = "enseignant.id", target = "enseignant.id")
    @Mapping(source = "anneeScolaire.id", target = "anneeScolaire.id")
    @Mapping(source = "filiere.id", target = "filiere.id")
    @Mapping(source = "credits", target = "credits")
    DomainUe toDomain(UeRequest ueRequest);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "credits", target = "credits")
    UeResponse toResponse(DomainUe domainUe);
}
