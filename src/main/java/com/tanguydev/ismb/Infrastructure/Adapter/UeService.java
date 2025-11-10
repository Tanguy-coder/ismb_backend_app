package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Gateway.AnneeScolaireRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.EnseignantRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.FiliereRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.MatiereRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.UeRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UeService implements UeServiceInterface {

    private final UeRepositoryInterface ueRepository;
    private final MatiereRepositoryInterface matiereRepository;
    private final EnseignantRepositoryInterface enseignantRepository;
    private final AnneeScolaireRepositoryInterface anneeScolaireRepository;
    private final FiliereRepositoryInterface filiereRepository;

    public UeService(UeRepositoryInterface ueRepository, MatiereRepositoryInterface matiereRepository, EnseignantRepositoryInterface enseignantRepository, AnneeScolaireRepositoryInterface anneeScolaireRepository, FiliereRepositoryInterface filiereRepository) {
        this.ueRepository = ueRepository;
        this.matiereRepository = matiereRepository;
        this.enseignantRepository = enseignantRepository;
        this.anneeScolaireRepository = anneeScolaireRepository;
        this.filiereRepository = filiereRepository;
    }

    @Override
    @Transactional
    public DomainUe save(DomainUe domainUe, Long matiereId, Long enseignantId, Long anneeScolaireId, Long filiereId) {
        DomainMatiere matiere = matiereRepository.findById(matiereId);
        DomainEnseignant enseignant = enseignantRepository.findById(enseignantId);
        DomainAnneeScolaire anneeScolaire = anneeScolaireRepository.getById(anneeScolaireId);
        DomainFiliere filiere = filiereRepository.findById(filiereId);

        domainUe.setMatiere(matiere);
        domainUe.setEnseignant(enseignant);
        domainUe.setAnneeScolaire(anneeScolaire);
        domainUe.setFiliere(filiere);

        return ueRepository.save(domainUe);
    }

    @Override
    public DomainUe findById(Long id) {
        return ueRepository.findById(id);
    }

    @Override
    public List<DomainUe> getAll() {
        return ueRepository.getAll();
    }

    @Override
    @Transactional
    public DomainUe update(Long id, DomainUe domainUe, Long matiereId, Long enseignantId, Long anneeScolaireId, Long filiereId) {
        DomainMatiere matiere = matiereRepository.findById(matiereId);
        DomainEnseignant enseignant = enseignantRepository.findById(enseignantId);
        DomainAnneeScolaire anneeScolaire = anneeScolaireRepository.getById(anneeScolaireId);
        DomainFiliere filiere = filiereRepository.findById(filiereId);

        domainUe.setMatiere(matiere);
        domainUe.setEnseignant(enseignant);
        domainUe.setAnneeScolaire(anneeScolaire);
        domainUe.setFiliere(filiere);

        return ueRepository.update(id, domainUe);
    }

    @Override
    public void delete(Long id) {
        ueRepository.delete(id);
    }
}
