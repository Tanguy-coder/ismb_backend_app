package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Response.AnneeScolaireResponse;
import com.tanguydev.ismb.Infrastructure.Models.AnneeScolaire;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnneeScolaireMapper {
    DomainAnneeScolaire toDomain(AnneeScolaire anneeScolaire);
    AnneeScolaire toJpa(DomainAnneeScolaire anneeScolaire);
    List<DomainAnneeScolaire> toDomainList(List<AnneeScolaire> anneeScolaires);
    List<AnneeScolaire> toJpaList(List<DomainAnneeScolaire> annees);
    AnneeScolaireResponse toJpaResponse(DomainAnneeScolaire anneeScolaire);
    List<AnneeScolaireResponse> toJpaResponseList(List<DomainAnneeScolaire> annees);
}
