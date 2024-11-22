package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.*;
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
        List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
        log.info("[finish] PetApplicationService - buscaPetsDoClienteComId");
        return PetClienteListResponse.converte(petsDoCliente) ;
    }

    @Override
    public PetClienteDetalhadeResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[start] PetApplicationService - buscaPetDoClienteComId");
        Pet pet = petRepository.buscaPetPeloId(idPet);
        log.info("[finish] PetApplicationService - buscaPetDoClienteComId");
        return new PetClienteDetalhadeResponse(pet);
    }

    @Override
    public void deletaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[start] PetApplicationService - deletaPetDoClienteComId");
        clienteService.buscaClientesAtravesId(idCliente);
        Pet pet = petRepository.buscaPetPeloId(idPet);
        petRepository.deletaPet(pet);
        log.info("[finish] PetApplicationService - deletaPetDoClienteComId");

    }
}
