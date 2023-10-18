package com.br.findYourPet.pet;

import com.br.findYourPet.utils.RequestResponse;
import com.br.findYourPet.pet.dto.PetDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(final PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createPet(final @RequestBody PetDto pet) {
        final RequestResponse<PetDto> createdPet = petService.createPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
    }
}
