package com.br.findYourPet.species;

import com.br.findYourPet.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> { }
