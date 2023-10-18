package com.br.findYourPet.race;

import com.br.findYourPet.race.dto.RaceDto;
import com.br.findYourPet.utils.RequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/race")
public class RaceController {

    private final RaceService service;

    public RaceController(final RaceService service) {
        this.service = service;
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createRace(final @RequestBody RaceDto dto) {
        final RequestResponse<RaceDto> createdRace = this.service.createRace(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRace);
    }

}
