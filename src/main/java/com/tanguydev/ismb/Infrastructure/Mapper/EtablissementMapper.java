package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Response.EtablissementResponse;
import com.tanguydev.ismb.Infrastructure.Models.Etablissement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtablissementMapper {
    Etablissement toJPa(DomainEtablissement etablissement);
    DomainEtablissement toDomain(Etablissement etablissement);
    List<Etablissement> toJPaList(List<DomainEtablissement> etablissements);
    List<DomainEtablissement> toDomainList(List<Etablissement> etablissements);

    EtablissementResponse toResponse(DomainEtablissement etablissement);
    List<EtablissementResponse> toResponseList(List<DomainEtablissement> etablissements);
}
