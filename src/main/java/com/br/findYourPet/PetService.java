package com.br.findYourPet;

import com.br.findYourPet.dto.PetDto;
import com.br.findYourPet.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetRepository repository;
    private final PetMapper mapper;

    @Autowired
    public PetService(PetRepository repository, final PetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RequestResponse<PetDto> createPet(final PetDto pet) {
        Pet entity = (Pet) this.mapper.mapDtoToEntity(pet, Pet.class);
        this.repository.save(entity);
        return RequestResponse.ok(pet);
    }

}
