package br.com.petz.cliente_pet.pet.application.service;

import br.com.petz.cliente_pet.pet.domain.Pet;

import java.util.List;
import java.util.UUID;

public interface PetRepository {
    Pet salvaPet(Pet pet);
    List<Pet> buscaPetsDoClienteComId(UUID idCliente);
    Pet buscaPetPeloId(UUID idPet);
    void deletaPet(Pet pet);
}
