package com.br.findYourPet.race;

import com.br.findYourPet.race.dto.RaceDto;
import com.br.findYourPet.race.model.Race;
import com.br.findYourPet.species.SpeciesRepository;
import com.br.findYourPet.species.model.Species;
import com.br.findYourPet.utils.Mapper;
import com.br.findYourPet.utils.RequestResponse;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    private final RaceRepository repository;

    private final SpeciesRepository speciesRepository;

    private final Mapper<RaceDto, Race> mapper;

    public RaceService(final RaceRepository repository, final SpeciesRepository speciesRepository, final Mapper<RaceDto, Race> mapper) {
        this.repository = repository;
        this.speciesRepository = speciesRepository;
        this.mapper = mapper;
    }

    public RequestResponse<RaceDto> getRace(final Long raceId) {
        Race entity = this.repository.getReferenceById(raceId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, RaceDto.class));
    }

    public RequestResponse<RaceDto> createRace(final RaceDto dto) {
        final Species species = this.speciesRepository.getReferenceById(dto.getSpecies());

        Race entity = this.mapper.mapDtoToEntity(dto, Race.class);
        entity.setSpecies(species);

        this.repository.save(entity);
        return RequestResponse.ok(dto);
    }

    public RequestResponse<RaceDto> updateRace(final RaceDto dto, final Long raceId) {
        final Race entity = this.repository.getReferenceById(raceId);
        this.mapper.mapDtoToEntity(dto, Race.class);
        this.repository.save(entity);
        return RequestResponse.ok(dto);
    }

    public RequestResponse<RaceDto> deleteRace(final Long raceId) {
        final Race entity = this.repository.getReferenceById(raceId);
        this.repository.deleteById(raceId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, RaceDto.class));
    }
}
