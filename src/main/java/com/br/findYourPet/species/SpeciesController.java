package com.br.findYourPet.species;

import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.species.dto.SpeciesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    public final SpeciesService service;

    public SpeciesController(final SpeciesService service) {
        this.service = service;
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createSpecies(final @RequestBody SpeciesDto dto) {
        final RequestResponse<SpeciesDto> createdSpecies = service.createSpecies(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpecies);
    }

}
