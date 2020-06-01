package com.example.pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marta Siudzińska
 */
@Data
@NoArgsConstructor
public class PetDto {
    private String petsName;
    private int petsAge;
    private Pet.Race race;
}
