package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.cliente.application.api.ClienteDetalhadoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID idCliente,
            @Valid @RequestBody PetRequest petRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PetClienteListResponse> getPetsDoClienteComId(@PathVariable UUID idCliente);

    @GetMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.OK)
    PetClienteDetalhadeResponse getPetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);

    @DeleteMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);

    @PatchMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    PetResponse patchPet(@PathVariable UUID idCliente, @PathVariable UUID idPet,
                        @Valid @RequestBody PetAlteracaoRequest petAlteracaoRequest);



}
