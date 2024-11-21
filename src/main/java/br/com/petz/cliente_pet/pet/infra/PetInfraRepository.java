package br.com.petz.cliente_pet.pet.infra;

import br.com.petz.cliente_pet.pet.application.service.PetRepository;
import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
    private final PetSpringDataJPARepository petSpringDataJPARepository;

    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[start] PetInfraRepository - salvaPet");
        petSpringDataJPARepository.save(pet);
        log.info("[finish] PetInfraRepository - salvaPet");
        return pet;
    }
}
