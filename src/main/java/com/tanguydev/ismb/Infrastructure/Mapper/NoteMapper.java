package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Response.NoteResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Models.Note;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EtudiantMapper.class, UeMapper.class, AnneeScolaireMapper.class})
public interface NoteMapper {

    Note toJpa(DomainNote domainNote, @Context CycleAvoidingMappingContext context);

    DomainNote toDomain(Note note, @Context CycleAvoidingMappingContext context);

    NoteResponse toResponse(DomainNote domainNote);
}
