package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Response.NoteResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Note;
import com.tanguydev.ismb.Infrastructure.Request.NoteRequest;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { EtudiantMapper.class, UeMapper.class, AnneeScolaireMapper.class, FiliereMapper.class })
public interface NoteMapper {

    @Mapping(target = "filiere", ignore = true)
    @Mapping(target = "etudiant", ignore = true)
    @Mapping(target = "ue", ignore = true)
    @Mapping(target = "anneeScolaire", ignore = true)
    Note toJpa(DomainNote domainNote, @Context CycleAvoidingMappingContext context);

    List<Note> toJpaList(List<DomainNote> domainNotes, @Context CycleAvoidingMappingContext context);

    DomainNote toDomain(Note note, @Context CycleAvoidingMappingContext context);

    List<DomainNote> toDomainList(List<Note> notes, @Context CycleAvoidingMappingContext context);

    // Expose nested relations in response DTO using corresponding mappers
    NoteResponse toResponse(DomainNote domainNote);

    List<NoteResponse> toResponseList(List<DomainNote> domainNotes);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "etudiant.id", source = "etudiant.id")
    @Mapping(target = "ue.id", source = "ue.id")
    @Mapping(target = "anneeScolaire.id", source = "anneeScolaire.id")
    @Mapping(target = "filiere.id", source = "filiere.id")
    DomainNote toDomain(NoteRequest noteRequest);

    List<DomainNote> toDomainList(List<NoteRequest> noteRequests);

}
