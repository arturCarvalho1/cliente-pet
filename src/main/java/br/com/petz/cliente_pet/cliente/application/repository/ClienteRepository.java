package br.com.petz.cliente_pet.cliente.application.repository;

import br.com.petz.cliente_pet.cliente.application.domain.Cliente;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}
