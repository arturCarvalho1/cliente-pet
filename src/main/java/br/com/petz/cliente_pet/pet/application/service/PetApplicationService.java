package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.PetClienteListResponse;
import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;
import br.com.petz.cliente_pet.pet.application.api.PetService;
import br.com.petz.cliente_pet.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
   private final ClienteService clienteService;
    private final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
        log.info("[start] PetApplicationService - criaPet");
        clienteService.buscaClientesAtravesId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[finish] PetApplicationService - criaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[start] PetApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClientesAtravesId(idCliente);
        log.info("[finish] PetApplicationService - buscaPetsDoClienteComId");
        return null;
    }
}
