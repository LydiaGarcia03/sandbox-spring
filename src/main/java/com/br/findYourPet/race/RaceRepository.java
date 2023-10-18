package com.br.findYourPet.race;

import com.br.findYourPet.race.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> { }