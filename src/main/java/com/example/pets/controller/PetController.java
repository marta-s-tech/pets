package com.example.pets.controller;

import com.example.pets.model.Pet;
import com.example.pets.model.PetDto;
import com.example.pets.model.PetUpdateRequest;
import com.example.pets.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marta Siudzińska
 */
@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PutMapping()
    public ResponseEntity<Void> putIntoDatabase(@RequestBody Pet obiekt) {
        boolean result = petService.putOrUpdate(obiekt);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public List<PetDto> getAllFromDatabase() {
        return petService.listAllPets();
    }

    @GetMapping("/search-owner")
    public List<Pet> getFromDatabaseByLastName(@RequestParam(name = "ownerName") String owner) {
        return petService.searchByOwnerName(owner);
    }

    @GetMapping("/search-race")
    public List<PetDto> getFromDatabaseByRace(@RequestParam(name = "race") Pet.Race race) {
        return petService.searchByRace(race);
    }

    @GetMapping("/search/{age_from}/{age_to}")
    public List<PetDto> getFromDatabaseByAge(@PathVariable(name = "age_from") int ageFrom,
                                             @PathVariable(name = "age_to") int ageTo) {
        return petService.searchByAge(ageFrom, ageTo);
    }

    @GetMapping("/search/{weight_max}")
    public List<Pet> getFromDatabaseByMaxWeight(@PathVariable(name = "weight_max") Double weightMax) {
        return petService.searchByMaxWeight(weightMax);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFromDatabaseById(@RequestParam(name = "id") Long id) {
        boolean isRemoved = petService.delete(id);
        if (isRemoved) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Void> updatePet(@RequestBody PetUpdateRequest updateRequest) {
        boolean result = petService.update(updateRequest);

        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build(); // 400 = bad request = wina błędu zapytania = użytkownika
        }
    }

}
