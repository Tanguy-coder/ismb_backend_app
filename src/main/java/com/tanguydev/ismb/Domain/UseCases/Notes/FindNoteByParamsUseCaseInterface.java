package com.tanguydev.ismb.Domain.UseCases.Notes;

import com.tanguydev.ismb.Domain.Entity.DomainNote;

import java.util.List;

public interface FindNoteByParamsUseCaseInterface {
    List<DomainNote> findByParams(Long anneeScolaireId, Long filiereId, Long ueId, String session, Integer periode);
}