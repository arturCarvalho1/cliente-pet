package br.com.petz.cliente_pet.cliente.application.api;

import br.com.petz.cliente_pet.cliente.application.domain.Sexo;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;
    private Sexo sexo;
    private Boolean aceitaTermos;
    private LocalDateTime dataHoraDoCadastro;
}
