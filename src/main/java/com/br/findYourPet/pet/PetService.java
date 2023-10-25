package com.br.findYourPet.pet;

import com.br.findYourPet.utils.Mapper;
import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.pet.dto.PetDto;
import com.br.findYourPet.pet.model.Pet;
import com.br.findYourPet.race.RaceRepository;
import com.br.findYourPet.race.model.Race;
import com.br.findYourPet.species.SpeciesRepository;
import com.br.findYourPet.species.model.Species;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetRepository repository;
    private final SpeciesRepository speciesRepository;
    private final RaceRepository raceRepository;
    private final Mapper<PetDto, Pet> mapper;

    @Autowired
    public PetService(final PetRepository repository, final SpeciesRepository speciesRepository, final RaceRepository raceRepository, final Mapper<PetDto, Pet> mapper) {
        this.repository = repository;
        this.speciesRepository = speciesRepository;
        this.raceRepository = raceRepository;
        this.mapper = mapper;
    }

    public RequestResponse<PetDto> getPet(final Long petId) {
        Pet entity = this.repository.getReferenceById(petId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, PetDto.class));
    }

    public RequestResponse<PetDto> createPet(final PetDto pet) {
        Species species = this.speciesRepository.getReferenceById(pet.getSpecies());
        Race race = this.raceRepository.getReferenceById(pet.getRace());

        Pet entity = this.mapper.mapDtoToEntity(pet, Pet.class);
        entity.setSpecies(species);
        entity.setRace(race);

        this.repository.save(entity);
        return RequestResponse.ok(pet);
    }

    public RequestResponse<PetDto> updatePet(final PetDto pet, final Long petId) {
        Pet entity = this.repository.getReferenceById(petId);
        BeanUtils.copyProperties(pet, entity);

        this.repository.save(entity);

        return RequestResponse.ok(pet);
    }

    public RequestResponse<PetDto> deletePet(final Long petId) {
        Pet entity = this.repository.getReferenceById(petId);
        this.repository.deleteById(petId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, PetDto.class));
    }
}
