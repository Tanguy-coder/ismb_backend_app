package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Presenter.EtablissementPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EtablissementResponse;
import com.tanguydev.ismb.Domain.UseCases.Etablissement.CreateEtablissementUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Etablissement.GetEtablissementByIdUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Etablissement.ListEtablissementUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Etablissement.UpdateEtablissementUseCaseInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/etablissements")
public class EtablissementController {

    private final CreateEtablissementUseCaseInterface createEtablissementUseCase;
    private final ListEtablissementUseCaseInterface listEtablissementUseCase;
    private final GetEtablissementByIdUseCaseInterface getEtablissementByIdUseCase;
    private final UpdateEtablissementUseCaseInterface updateEtablissementUseCase;
    private final EtablissementPresenterInterface presenter;

    public EtablissementController(CreateEtablissementUseCaseInterface createEtablissementUseCase, ListEtablissementUseCaseInterface listEtablissementUseCase, GetEtablissementByIdUseCaseInterface getEtablissementByIdUseCase, UpdateEtablissementUseCaseInterface updateEtablissementUseCase, EtablissementPresenterInterface presenter) {
        this.createEtablissementUseCase = createEtablissementUseCase;
        this.listEtablissementUseCase = listEtablissementUseCase;
        this.getEtablissementByIdUseCase = getEtablissementByIdUseCase;
        this.updateEtablissementUseCase = updateEtablissementUseCase;
        this.presenter = presenter;
    }

    @GetMapping
    public ResponseEntity<List<EtablissementResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listEtablissementUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementResponse> show(@PathVariable Long id) {
        // Note: findById is used from the service, but the use case should be getEtablissementByIdUseCase.execute(id)
        // This will require fixing the service and repository layer for findById vs getById.
        // For now, assuming getEtablissementByIdUseCase exists and works.
        return ResponseEntity.ok(presenter.present(getEtablissementByIdUseCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<EtablissementResponse> store(@RequestParam("nom") String nom,
                                                     @RequestParam("contact") String contact,
                                                     @RequestParam("email") String email,
                                                     @RequestParam("numero") String numero,
                                                     @RequestParam(value = "logo", required = false) MultipartFile logoFile,
                                                     @RequestParam(value = "image", required = false) MultipartFile imageFile) {

        DomainEtablissement newEtablissement = new DomainEtablissement();
        newEtablissement.setNom(nom);
        newEtablissement.setContact(contact);
        newEtablissement.setEmail(email);
        newEtablissement.setNumero(numero);

        DomainEtablissement createdEtablissement = createEtablissementUseCase.execute(newEtablissement, logoFile, imageFile);

        return ResponseEntity.ok(presenter.present(createdEtablissement));
    }

    // The update method will also need to be adapted for multipart requests.
    // This is a placeholder for now.
    @PutMapping("/{id}")
    public ResponseEntity<EtablissementResponse> update(@PathVariable Long id, @RequestBody DomainEtablissement etablissement) {
        return ResponseEntity.ok(presenter.present(updateEtablissementUseCase.execute(id, etablissement)));
    }
}
