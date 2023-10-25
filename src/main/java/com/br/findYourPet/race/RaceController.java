package com.br.findYourPet.race;

import com.br.findYourPet.race.dto.RaceDto;
import com.br.findYourPet.utils.RequestResponse;
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
@RequestMapping("/race")
public class RaceController {

    private final RaceService service;

    public RaceController(final RaceService service) {
        this.service = service;
    }

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getRace(final @RequestParam Long raceId) {
        final RequestResponse<RaceDto> foundRace = this.service.getRace(raceId);
        return ResponseEntity.status(HttpStatus.OK).body(foundRace);
    }
    
    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createRace(final @RequestBody RaceDto dto) {
        final RequestResponse<RaceDto> createdRace = this.service.createRace(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRace);
    }

    @PatchMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateRace(final @RequestBody RaceDto dto, final @RequestParam Long raceId) {
        final RequestResponse<RaceDto> updatedRace = this.service.updateRace(dto, raceId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRace);
    }
    
    @DeleteMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deleteRace(final @RequestParam Long raceId) {
        final RequestResponse<RaceDto> deletedRace = this.service.deleteRace(raceId);
        return ResponseEntity.status(HttpStatus.OK).body(deletedRace);
    }
    

}
