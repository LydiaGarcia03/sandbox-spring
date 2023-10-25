package com.br.findYourPet.species;

import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.species.dto.SpeciesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    public final SpeciesService service;

    public SpeciesController(final SpeciesService service) {
        this.service = service;
    }

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getSpecies(final @RequestParam Long speciesId) {
        final RequestResponse<SpeciesDto> foundSpecies = service.getSpecies(speciesId);
        return ResponseEntity.status(HttpStatus.OK).body(foundSpecies);
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createSpecies(final @RequestBody SpeciesDto dto) {
        final RequestResponse<SpeciesDto> createdSpecies = service.createSpecies(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpecies);
    }

    @PatchMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateSpecies(final @RequestBody SpeciesDto dto, final @RequestParam Long speciesId) {
        final RequestResponse<SpeciesDto> updatedSpecies = service.updateSpecies(dto, speciesId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedSpecies);
    }

    @DeleteMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteSpecies(final @RequestParam Long speciesId) {
        final RequestResponse<SpeciesDto> deletedSpecies = service.deleteSpecies(speciesId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedSpecies);
    }

}
