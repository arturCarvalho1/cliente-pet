package br.com.petz.cliente_pet.cliente.infra;

import br.com.petz.cliente_pet.cliente.application.domain.Cliente;
import br.com.petz.cliente_pet.cliente.application.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository{
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
public Cliente salva(Cliente cliente){
       log.info("[inicia] ClienteInfraRepository - salva");
       clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - salva");
       return cliente;

    }

    @Override
    public List<Cliente> buscaTodosClintes() {
        log.info("[inicia] ClienteInfraRepository - buscaTodosClintes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] ClienteInfraRepository - buscaTodosClintes");
        return todosClientes;
    }

    @Override
    public Cliente buscaClienteAtravesId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - buscaClienteAtravesId");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        log.info("[finaliza] ClienteInfraRepository - buscaClienteAtravesId");
        return cliente;
    }

}
