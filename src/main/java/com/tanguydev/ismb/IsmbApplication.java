package com.tanguydev.ismb;

import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;
import com.tanguydev.ismb.Domain.Ports.NoteServiceInterface;
import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;
import com.tanguydev.ismb.Domain.UseCases.Filiere.CreateFiliereUseCase;
import com.tanguydev.ismb.Domain.UseCases.Filiere.GetFiliereByIdUseCase;
import com.tanguydev.ismb.Domain.UseCases.Filiere.ListFiliereUseCase;
import com.tanguydev.ismb.Domain.UseCases.Filiere.UpdateFiliereUseCase;
import com.tanguydev.ismb.Domain.UseCases.Matiere.*;
import com.tanguydev.ismb.Domain.UseCases.Niveau.CreateNiveauUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.GetNiveauByIdUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.ListNiveauUseCase;
import com.tanguydev.ismb.Domain.UseCases.Niveau.UpdateNiveauUseCase;
import com.tanguydev.ismb.Domain.UseCases.Notes.CreateNoteUseCase;
import com.tanguydev.ismb.Domain.UseCases.Notes.FindNoteByParamsUseCase;
import com.tanguydev.ismb.Domain.UseCases.Notes.UpdateNoteUseCase;
import com.tanguydev.ismb.Domain.UseCases.Ue.*;
import com.tanguydev.ismb.Domain.UseCases.annee.CreateAnneeScolaireUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.GetAnneeByIdUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.ListAnneeUseCase;
import com.tanguydev.ismb.Domain.UseCases.annee.UpdateAnneeUseCase;
import com.tanguydev.ismb.Infrastructure.Mapper.*;
import com.tanguydev.ismb.Infrastructure.Presenter.AnneeScolairePresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.EtablissementPresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.FilierePresenter;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;
import com.tanguydev.ismb.Domain.UseCases.Etablissement.*;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;
import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;
import com.tanguydev.ismb.Domain.Ports.RoleServiceInterface;
import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;
import com.tanguydev.ismb.Domain.UseCases.Enseignant.*;
import com.tanguydev.ismb.Infrastructure.Presenter.EnseignantPresenter;
import com.tanguydev.ismb.Domain.UseCases.Etudiant.*;
import com.tanguydev.ismb.Domain.UseCases.Permission.*;
import com.tanguydev.ismb.Domain.UseCases.Role.*;
import com.tanguydev.ismb.Infrastructure.Presenter.EtudiantPresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.MatierePresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.PermissionPresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.RolePresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.NiveauPresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.NotePresenter;
import com.tanguydev.ismb.Infrastructure.Presenter.UePresenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
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

	@Bean
	public PermissionPresenter permissionPresenter(PermissionMapper permissionMapper){
		return new PermissionPresenter(permissionMapper);
	}

	@Bean
	public RolePresenter rolePresenter(RoleMapper roleMapper){
		return new RolePresenter(roleMapper);
	}

	@Bean
	public MatierePresenter matierePresenter(MatiereMapper matiereMapper) {
		return new MatierePresenter(matiereMapper);
	}

	@Bean
	public EnseignantPresenter enseignantPresenter(EnseignantMapper enseignantMapper) {
		return new EnseignantPresenter(enseignantMapper);
	}

	@Bean
	public UePresenter uePresenter(UeMapper ueMapper) {
		return new UePresenter(ueMapper);
	}

	@Bean
	public NotePresenter notePresenter(NoteMapper noteMapper) {
		return new NotePresenter(noteMapper);
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

	@Bean
	public DeleteEtudiantUseCase deleteEtudiantUseCase(EtudiantServiceInterface etudiantService) {
		return new DeleteEtudiantUseCase(etudiantService);
	}

	@Bean
	public CreatePermissionUseCase createPermissionUseCase(PermissionServiceInterface permissionService) {
		return new CreatePermissionUseCase(permissionService);
	}

	@Bean
	public GetAllPermissionsUseCase getAllPermissionsUseCase(PermissionServiceInterface permissionService) {
		return new GetAllPermissionsUseCase(permissionService);
	}

	@Bean
	public GetPermissionByIdUseCase getPermissionByIdUseCase(PermissionServiceInterface permissionService) {
		return new GetPermissionByIdUseCase(permissionService);
	}

	@Bean
	public UpdatePermissionUseCase updatePermissionUseCase(PermissionServiceInterface permissionService) {
		return new UpdatePermissionUseCase(permissionService);
	}

	@Bean
	public DeletePermissionUseCase deletePermissionUseCase(PermissionServiceInterface permissionService) {
		return new DeletePermissionUseCase(permissionService);
	}

	@Bean
	public GetAllRolesUseCase getAllRolesUseCase(RoleServiceInterface roleService) {
		return new GetAllRolesUseCase(roleService);
	}

	@Bean
	public GetRoleByIdUseCase getRoleByIdUseCase(RoleServiceInterface roleService) {
		return new GetRoleByIdUseCase(roleService);
	}

	@Bean
	public AddPermissionToRoleUseCase addPermissionToRoleUseCase(RoleServiceInterface roleService) {
		return new AddPermissionToRoleUseCase(roleService);
	}

	@Bean
	public RemovePermissionFromRoleUseCase removePermissionFromRoleUseCase(RoleServiceInterface roleService) {
		return new RemovePermissionFromRoleUseCase(roleService);
	}

	@Bean
	public CreateMatiereUseCase createMatiereUseCase(MatiereServiceInterface matiereService) {
		return new CreateMatiereUseCase(matiereService);
	}

	@Bean
	public ListMatiereUseCase listMatiereUseCase(MatiereServiceInterface matiereService) {
		return new ListMatiereUseCase(matiereService);
	}

	@Bean
	public GetMatiereByIdUseCase getMatiereByIdUseCase(MatiereServiceInterface matiereService) {
		return new GetMatiereByIdUseCase(matiereService);
	}

	@Bean
	public UpdateMatiereUseCase updateMatiereUseCase(MatiereServiceInterface matiereService) {
		return new UpdateMatiereUseCase(matiereService);
	}

	@Bean
	public DeleteMatiereUseCase deleteMatiereUseCase(MatiereServiceInterface matiereService) {
		return new DeleteMatiereUseCase(matiereService);
	}

	@Bean
	public CreateEnseignantUseCase createEnseignantUseCase(EnseignantServiceInterface enseignantService) {
		return new CreateEnseignantUseCase(enseignantService);
	}

	@Bean
	public ListEnseignantUseCase listEnseignantUseCase(EnseignantServiceInterface enseignantService) {
		return new ListEnseignantUseCase(enseignantService);
	}

	@Bean
	public GetEnseignantByIdUseCase getEnseignantByIdUseCase(EnseignantServiceInterface enseignantService) {
		return new GetEnseignantByIdUseCase(enseignantService);
	}

	@Bean
	public UpdateEnseignantUseCase updateEnseignantUseCase(EnseignantServiceInterface enseignantService) {
		return new UpdateEnseignantUseCase(enseignantService);
	}

	@Bean
	public DeleteEnseignantUseCase deleteEnseignantUseCase(EnseignantServiceInterface enseignantService) {
		return new DeleteEnseignantUseCase(enseignantService);
	}

	@Bean
	public CreateUeUseCase createUeUseCase(UeServiceInterface ueService) {
		return new CreateUeUseCase(ueService);
	}

	@Bean
	public ListUeUseCase listUeUseCase(UeServiceInterface ueService) {
		return new ListUeUseCase(ueService);
	}

	@Bean
	public GetUeByIdUseCase getUeByIdUseCase(UeServiceInterface ueService) {
		return new GetUeByIdUseCase(ueService);
	}

	@Bean
	public UpdateUeUseCase updateUeUseCase(UeServiceInterface ueService) {
		return new UpdateUeUseCase(ueService);
	}

	@Bean	public DeleteUeUseCase deleteUeUseCase(UeServiceInterface ueService) {
		return new DeleteUeUseCase(ueService);
	}

	@Bean
	public CreateNoteUseCase createNoteUseCase(NoteServiceInterface noteService) {
		return new CreateNoteUseCase(noteService);
	}

    @Bean
    public FindNoteByParamsUseCase findNoteByParamsUseCase(NoteServiceInterface noteService) {
        return new FindNoteByParamsUseCase(noteService);
    }

    @Bean
    public UpdateNoteUseCase updateNoteUseCase(NoteServiceInterface noteService) {
        return new UpdateNoteUseCase(noteService);
    }
}