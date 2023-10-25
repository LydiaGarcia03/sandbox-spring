package com.br.findYourPet.species;

import com.br.findYourPet.species.model.Species;
import com.br.findYourPet.utils.Mapper;
import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.species.dto.SpeciesDto;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {

    private final SpeciesRepository repository;
    private final Mapper<SpeciesDto, Species> mapper;


    public SpeciesService(final SpeciesRepository repository, final Mapper<SpeciesDto, Species> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RequestResponse<SpeciesDto> getSpecies(final Long speciesId) {
        final Species entity = this.repository.getReferenceById(speciesId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, SpeciesDto.class));
    }

    public RequestResponse<SpeciesDto> createSpecies(final SpeciesDto dto) {
        this.repository.save(this.mapper.mapDtoToEntity(dto, Species.class));
        return RequestResponse.ok(dto);
    }

    public RequestResponse<SpeciesDto> updateSpecies(final SpeciesDto dto, final Long speciesId) {
        final Species entity = this.repository.getReferenceById(speciesId);
        this.mapper.mapDtoToEntity(dto, Species.class);
        this.repository.save(entity);
        return RequestResponse.ok(dto);
    }

    public RequestResponse<SpeciesDto> deleteSpecies(final Long speciesId) {
        final Species entity = this.repository.getReferenceById(speciesId);
        this.repository.deleteById(speciesId);
        return RequestResponse.ok(this.mapper.mapEntityToDto(entity, SpeciesDto.class));
    }
}
