package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Entity.DomainParcourtEtudiant;
import com.tanguydev.ismb.Domain.Response.ListClasseResponse;
import com.tanguydev.ismb.Infrastructure.Models.ParcourtEtudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring", uses = {EtudiantMapper.class, AnneeScolaireMapper.class, UserMapper.class, FiliereMapper.class,})
public abstract class ParcourtMapper {
    public abstract DomainParcourtEtudiant toDomain(ParcourtEtudiant parcourtEtudiant);
    public abstract ParcourtEtudiant toJpa(DomainParcourtEtudiant domainParcourtEtudiant);

    public abstract List<DomainParcourtEtudiant> toDomainList(List<ParcourtEtudiant> parcourtEtudiants);
    public abstract List<ParcourtEtudiant> toJpaList(List<DomainParcourtEtudiant> domainParcourtEtudiants);


    @Mapping(source = "user.nom", target = "nom")
    @Mapping(source = "user.prenom", target = "prenom")
    @Mapping(source = "matricule", target = "matricule")
    @Mapping(source = "sexe", target = "sexe")
    @Mapping(source = "dateNaissance", target = "age", qualifiedByName = "calculateAge")
    @Mapping(source = "dateNaissance", target = "dateNaissance", qualifiedByName = "birthDate")
    @Mapping(source = "lieuNaissance", target = "lieuNaissance")
    @Mapping(source = "nationalite", target = "nationalite")
    @Mapping(source = "user.contact", target = "telephone")
    @Mapping(source = "photo", target = "photo")
    @Mapping(source = "filiere.libelle", target = "filiere")
    @Mapping(target = "statut", constant = "N")
    public abstract ListClasseResponse toResponse(DomainEtudiant etudiant);
    
    public abstract List<ListClasseResponse> toResponseList(List<DomainEtudiant> etudiants);

    @Named("calculateAge")
    protected Integer calculateAge(LocalDate dateNaissance) {
        if (dateNaissance == null) {
            return null;
        }
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    @Named("birthDate")
    protected String birthDate(LocalDate dateNaissance) {
        if (dateNaissance == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateNaissance.format(formatter);
    }

}
