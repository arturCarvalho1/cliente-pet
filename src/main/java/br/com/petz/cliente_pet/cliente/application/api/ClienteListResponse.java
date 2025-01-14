package br.com.petz.cliente_pet.cliente.application.api;

import br.com.petz.cliente_pet.cliente.application.domain.Cliente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteListResponse::new)
                .collect(Collectors.toList());
    }

    public ClienteListResponse(Cliente cliente) {
        this.celular = cliente.getCelular();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
    }
}
