package br.com.petz.cliente_pet.pet.application.api;

import jakarta.validation.Valid;

import java.util.UUID;

public interface PetService {
     PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);
}
