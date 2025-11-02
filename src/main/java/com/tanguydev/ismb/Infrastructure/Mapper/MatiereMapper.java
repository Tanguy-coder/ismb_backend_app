package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Response.MatiereResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Matiere;
import com.tanguydev.ismb.Infrastructure.Request.MatiereRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NiveauMapper.class})
public interface MatiereMapper {

    Matiere toJpa(DomainMatiere domainMatiere, @Context CycleAvoidingMappingContext context);

    DomainMatiere toDomain(Matiere matiere, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "niveau.id", target = "niveau.id")
    DomainMatiere toDomain(MatiereRequest matiereRequest);

    MatiereResponse toResponse(DomainMatiere domainMatiere);
}
