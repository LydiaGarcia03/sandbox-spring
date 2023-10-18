package com.br.findYourPet.pet;

import com.br.findYourPet.utils.Mapper;
import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.pet.dto.PetDto;
import com.br.findYourPet.pet.model.Pet;
import com.br.findYourPet.race.RaceRepository;
import com.br.findYourPet.race.model.Race;
import com.br.findYourPet.species.SpeciesRepository;
import com.br.findYourPet.species.model.Species;
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

    public RequestResponse<PetDto> createPet(final PetDto pet) {
        Species species = this.speciesRepository.getReferenceById(pet.getSpecies());
        Race race = this.raceRepository.getReferenceById(pet.getRace());

        Pet entity = this.mapper.mapDtoToEntity(pet, Pet.class);
        entity.setSpecies(species);
        entity.setRace(race);

        this.repository.save(entity);
        return RequestResponse.ok(pet);
    }

}
