package com.example.pets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marta Siudzińska
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetUpdateRequest {
    private Long id;
    private String newName;
    private Integer newAge;
    private String newOwner;
    private Pet.Race newRace;
}
