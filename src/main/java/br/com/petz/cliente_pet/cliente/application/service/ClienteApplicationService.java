package br.com.petz.cliente_pet.cliente.application.service;

import br.com.petz.cliente_pet.cliente.application.api.*;
import br.com.petz.cliente_pet.cliente.application.domain.Cliente;
import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;
    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest){
        log.info("[inicia] ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosClintes();
        log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public ClienteDetalhadoResponse buscaClientesAtravesId(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - buscaClientesAtravesId");
         Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        log.info("[finaliza] ClienteApplicationService - buscaClientesAtravesId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void deletaClienteAtravesId(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - deletaClienteAtravesId ");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        clienteRepository.deletaCliente(cliente);
        log.info("[finaliza] ClienteApplicationService - deletaClienteAtravesId ");
    }

    @Override
    public void patcAlteracaoCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[inicia] ClienteApplicationService - patcAlteracaoCliente");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.salva(cliente);
        log.info("[finaliza] ClienteApplicationService - patcAlteracaoCliente");

    }
}
