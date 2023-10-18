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

    public RequestResponse<SpeciesDto> createSpecies(final SpeciesDto dto) {
        this.repository.save(this.mapper.mapDtoToEntity(dto, Species.class));
        return RequestResponse.ok(dto);
    }
}
