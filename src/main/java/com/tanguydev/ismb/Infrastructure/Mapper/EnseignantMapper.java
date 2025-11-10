package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Response.EnseignantResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Enseignant;
import com.tanguydev.ismb.Infrastructure.Request.EnseignantRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoleMapper.class, PermissionMapper.class})
public interface EnseignantMapper {

    @Mapping(source = "matiere", target = "matiere")
    Enseignant toJpa(DomainEnseignant enseignant, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "matiere", target = "matiere")
    DomainEnseignant toDomain(Enseignant enseignant, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "nom", target = "user.nom")
    @Mapping(source = "prenom", target = "user.prenom")
    @Mapping(source = "username", target = "user.username")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "password", target = "user.password")
    @Mapping(source = "roles", target = "user.roles")
    @Mapping(source = "contact", target = "user.contact")
    @Mapping(source = "matiere", target = "matiere")
    DomainEnseignant toDomain(EnseignantRequest enseignantRequest);

    List<Enseignant> toJpaList(List<DomainEnseignant> enseignants, @Context CycleAvoidingMappingContext context);

    List<DomainEnseignant> toDomainList(List<Enseignant> enseignants, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.nom", target = "nom")
    @Mapping(source = "user.prenom", target = "prenom")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.contact", target = "contact")
    @Mapping(source = "matiere", target = "matiere")
    EnseignantResponse toResponse(DomainEnseignant enseignant);

    List<EnseignantResponse> toResponseList(List<DomainEnseignant> enseignants);
}