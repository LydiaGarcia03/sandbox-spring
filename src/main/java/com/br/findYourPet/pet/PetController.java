package com.br.findYourPet.pet;

import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.pet.dto.PetDto;
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
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(final PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getPet(final @RequestParam Long petId) {
        final RequestResponse<PetDto> foundPet = petService.getPet(petId);
        return ResponseEntity.status(HttpStatus.OK).body(foundPet);
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createPet(final @RequestBody PetDto pet) {
        final RequestResponse<PetDto> createdPet = petService.createPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
    }

    @PatchMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePet(final @RequestBody PetDto pet, final @RequestParam Long petId) {
        final RequestResponse<PetDto> updatedPet = petService.updatePet(pet, petId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPet);
    }

    @DeleteMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deletePet(final @RequestParam Long petId) {
        final RequestResponse<PetDto> deletedPet = petService.deletePet(petId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedPet);
    }

}
