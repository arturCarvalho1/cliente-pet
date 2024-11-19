package br.com.petz.cliente_pet.cliente.application.service;

import br.com.petz.cliente_pet.cliente.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
    List<ClienteListResponse> buscaTodosClientes();
    ClienteDetalhadoResponse buscaClientesAtravesId(UUID idCliente);
    void deletaClienteAtravesId(UUID idCliente);
    void patcAlteracaoCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
}
