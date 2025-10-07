package com.tanguydev.ismb;

import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;
import com.tanguydev.ismb.Domain.UseCases.Filiere.CreateFiliereUseCase;
import com.tanguydev.ismb.Domain.UseCases.Filiere.GetFiliereByIdUseCase;
import com.tanguydev.ismb.Domain.UseCases.Filiere.ListFiliereUseCase;
import com.tanguydev.ismb.Domain.UseCases.Filiere.UpdateFiliereUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.CreateNiveauUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.GetNiveauByIdUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.ListNiveauUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.UpdateNiveauUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.CreateAnneeScolaireUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.GetAnneeByIdUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.ListAnneeUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.UpdateAnneeUseCase;
import com.tanguydev.ismb.Infrastructure.Mapper.AnneeScolaireMapper;
import com.tanguydev.ismb.Infrastructure.Mapper.EtablissementMapper;
import com.tanguydev.ismb.Infrastructure.Mapper.FiliereMapper;
import com.tanguydev.ismb.Infrastructure.Mapper.NiveauMapper;
import com.tanguydev.ismb.Infrastructure.Presenter.AnneeScolairePresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.EtablissementPresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.FilierePresenter;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;
import com.tanguydev.ismb.Domain.UseCases.Etablissement.*;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;
import com.tanguydev.ismb.Domain.UseCases.Etudiant.*;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import com.tanguydev.ismb.Infrastructure.Presenter.EtudiantPresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.NiveauPresenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IsmbApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsmbApplication.class, args);
	}

	/*******************************Presenters*********************************************************/
	@Bean
	public NiveauPresenter niveauPresenter(NiveauMapper niveauMapper){
		return new NiveauPresenter(niveauMapper);
	}

	@Bean
	public FilierePresenter filierePresenter(FiliereMapper filiereMapper){
		return new FilierePresenter(filiereMapper);
	}

	@Bean
	public AnneeScolairePresenter anneeScolairePresenter(AnneeScolaireMapper anneeScolaireMapper)
	{
		return new AnneeScolairePresenter(anneeScolaireMapper);
	}

	@Bean
	public EtablissementPresenter etablissementPresenter(EtablissementMapper etablissementMapper){
		return new EtablissementPresenter(etablissementMapper);
	}

	@Bean
	public EtudiantPresenter etudiantPresenter(EtudiantMapper etudiantMapper){
		return new EtudiantPresenter(etudiantMapper);
	}
	/*******************************UseCases*********************************************************/
	@Bean
	public CreateFiliereUseCase createFiliereUseCase(FiliereServiceInterface filiereServiceInterface){
		return new CreateFiliereUseCase(filiereServiceInterface);
	}

	@Bean
	public ListFiliereUseCase filiereUseCase(FiliereServiceInterface filiereServiceInterface){
		return new ListFiliereUseCase(filiereServiceInterface);
	}

	@Bean
	public GetFiliereByIdUseCase getFiliereByIdUseCase(FiliereServiceInterface filiereServiceInterface){
		return new GetFiliereByIdUseCase(filiereServiceInterface);
	}

	@Bean
	public UpdateFiliereUseCase updateFiliereUseCase(FiliereServiceInterface filiereServiceInterface){
		return new UpdateFiliereUseCase(filiereServiceInterface);
	}
	@Bean
	public CreateNiveauUseCase createNiveauUseCase(NiveauServiceInterface niveauServiceInterface){
		return new CreateNiveauUseCase(niveauServiceInterface);
	}

	@Bean
	public ListNiveauUseCase listNiveauUseCase(NiveauServiceInterface niveauServiceInterface){
		return new ListNiveauUseCase(niveauServiceInterface);
	}

	@Bean
	public GetNiveauByIdUseCase getNiveauByIdUseCase(NiveauServiceInterface niveauServiceInterface){
		return  new GetNiveauByIdUseCase(niveauServiceInterface);
	}

	@Bean
	public UpdateNiveauUseCase updateNiveauUseCase(NiveauServiceInterface niveauServiceInterface){
		return new UpdateNiveauUseCase(niveauServiceInterface);
	}
	@Bean
	public CreateAnneeScolaireUseCase createAnneeScolaireUseCase(AnneeScolaireServiceInterface anneeScolaireServiceInterface)
	{
		return new CreateAnneeScolaireUseCase(anneeScolaireServiceInterface);
	}

	@Bean
	public ListAnneeUseCase listAnneeUseCase(AnneeScolaireServiceInterface anneeScolaireServiceInterface)
	{
		return new ListAnneeUseCase(anneeScolaireServiceInterface);
	}

	@Bean
	public GetAnneeByIdUseCase getAnneeByIdUseCase(AnneeScolaireServiceInterface anneeScolaireServiceInterface)
	{
		return new GetAnneeByIdUseCase(anneeScolaireServiceInterface);
	}

	@Bean
	public UpdateAnneeUseCase updateAnneeUseCase(AnneeScolaireServiceInterface anneeScolaireServiceInterface)
	{
		return new UpdateAnneeUseCase(anneeScolaireServiceInterface);
	}

	@Bean
	public CreateEtablissementUseCase createEtablissementUseCase(EtablissementServiceInterface etablissementService) {
		return new CreateEtablissementUseCase(etablissementService);
	}

	@Bean
	public ListEtablissementUseCase listEtablissementUseCase(EtablissementServiceInterface etablissementService) {
		return new ListEtablissementUseCase(etablissementService);
	}

	@Bean
	public GetEtablissementByIdUseCase getEtablissementByIdUseCase(EtablissementServiceInterface etablissementService) {
		return new GetEtablissementByIdUseCase(etablissementService);
	}

	@Bean
	public UpdateEtablissementUseCase updateEtablissementUseCase(EtablissementServiceInterface etablissementService) {
		return new UpdateEtablissementUseCase(etablissementService);
	}

	@Bean
	public CreateEtudiantUseCase createEtudiantUseCase(EtudiantServiceInterface etudiantService) {
		return new CreateEtudiantUseCase(etudiantService);
	}

	@Bean
	public ListEtudiantUseCase listEtudiantUseCase(EtudiantServiceInterface etudiantService) {
		return new ListEtudiantUseCase(etudiantService);
	}

	@Bean
	public GetEtudiantByIdUseCase getEtudiantByIdUseCase(EtudiantServiceInterface etudiantService) {
		return new GetEtudiantByIdUseCase(etudiantService);
	}

	@Bean
	public UpdateEtudiantUseCase updateEtudiantUseCase(EtudiantServiceInterface etudiantService) {
		return new UpdateEtudiantUseCase(etudiantService);
	}

}
