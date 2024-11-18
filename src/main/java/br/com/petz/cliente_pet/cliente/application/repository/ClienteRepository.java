package br.com.petz.cliente_pet.cliente.application.repository;

import br.com.petz.cliente_pet.cliente.application.api.ClienteListResponse;
import br.com.petz.cliente_pet.cliente.application.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    List<Cliente> buscaTodosClintes();
}
