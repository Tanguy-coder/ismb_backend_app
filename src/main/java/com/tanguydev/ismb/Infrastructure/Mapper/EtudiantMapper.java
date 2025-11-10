package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.*;
import com.tanguydev.ismb.Domain.Response.EtudiantResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.*;
import com.tanguydev.ismb.Infrastructure.Request.EtudiantRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, RoleMapper.class, PermissionMapper.class, AnneeScolaireMapper.class, FiliereMapper.class, NiveauMapper.class})
public interface EtudiantMapper {

    Etudiant toJpa(DomainEtudiant etudiant, @Context CycleAvoidingMappingContext context);

    DomainEtudiant toDomain(Etudiant etudiant, @Context CycleAvoidingMappingContext context);

    ParcourtEtudiant toJpa(DomainParcourtEtudiant domain, @Context CycleAvoidingMappingContext context);

    DomainParcourtEtudiant toDomain(ParcourtEtudiant jpa, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "nom", target = "user.nom")
    @Mapping(source = "prenom", target = "user.prenom")
    @Mapping(source = "username", target = "user.username")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "password", target = "user.password")
    @Mapping(source = "roles", target = "user.roles")
    @Mapping(source = "contact", target = "user.contact") // Added mapping for contact
    @Mapping(source = "filiere.id", target = "filiere.id")
    DomainEtudiant toDomain(EtudiantRequest etudiantRequest);

    List<Etudiant> toJpaList(List<DomainEtudiant> etudiants, @Context CycleAvoidingMappingContext context);

    List<DomainEtudiant> toDomainList(List<Etudiant> etudiants, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.nom", target = "nom")
    @Mapping(source = "user.prenom", target = "prenom")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.contact", target = "contact")
    @Mapping(source = "filiere", target = "filiere")
    EtudiantResponse toResponse(DomainEtudiant etudiant);

    @Mapping(source = "nom", target = "user.nom")
    @Mapping(source = "prenom", target = "user.prenom")
    @Mapping(source = "username", target = "user.username")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "password", target = "user.password")
    @Mapping(source = "roles", target = "user.roles")
    @Mapping(source = "contact", target = "user.contact") // Added mapping for contact
    @Mapping(source = "filiere.libelle", target = "filiereInt")
    //@Mapping(source = "user.active", target = "isActive")

    List<EtudiantResponse> toResponseList(List<DomainEtudiant> etudiants);
}
