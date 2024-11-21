package br.com.petz.cliente_pet.pet.infra;

import br.com.petz.cliente_pet.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PetSpringDataJPARepository extends JpaRepository<Pet, UUID> {

}
