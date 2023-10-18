package com.br.findYourPet.pet.dto;

import com.br.findYourPet.enumerators.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {

    private String name;

    private Instant birthDate;

    private Long species;

    private Long race;

    private Size size;

    private String color;

}
