package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.pet.domain.Porte;
import br.com.petz.cliente_pet.pet.domain.SexoPet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class PetClienteDetalhadeResponse {
    private UUID idPet;
    private String nomePet;
    private Porte porte;
    private TipoPet tipo;
    private String microchip;
    private String raca;
    private SexoPet sexo;
    private String pelagemCor;
    private LocalDate dataNascimento;
    private String rga;
    private Integer peso;
}
