package com.example.pets.repository;

import com.example.pets.model.Pet;
import com.example.pets.model.PetDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Marta Siudzińska
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByOwnerNameContaining(String owner);

    List<Pet> findAllByRace(Pet.Race race);

    List<Pet> findAllByAgeBetween(Integer ageFrom, Integer ageTo);

    List<Pet> findAllByWeightBetween(Double weightFrom, Double weightTo);

    List<Pet> findAllByWeightIsLessThanEqual(Double weightMax);
}
