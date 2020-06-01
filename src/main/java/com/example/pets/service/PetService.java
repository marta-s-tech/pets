package com.example.pets.service;

import com.example.pets.model.Pet;
import com.example.pets.model.PetDto;
import com.example.pets.model.PetUpdateRequest;
import com.example.pets.model.mapper.PetMapper;
import com.example.pets.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Marta Siudzińska
 */
@Service
@AllArgsConstructor
public class PetService {

    private PetRepository petRepository;
    private PetMapper petMapper;

    public boolean putOrUpdate(Pet pet) {
        petRepository.save(pet);
        return true;
    }

    public List<PetDto> listAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::mapPetToDto)
                .collect(Collectors.toList());

    }

    public List<Pet> searchByOwnerName(String owner) {
        return petRepository.findAllByOwnerNameContaining(owner);
    }

    public List<PetDto> searchByRace(Pet.Race race) {
        return petRepository.findAllByRace(race)
                .stream()
                .map(petMapper::mapPetToDto)
                .collect(Collectors.toList());
    }

    public List<PetDto> searchByAge(Integer ageFrom, Integer ageTo) {
        return petRepository.findAllByAgeBetween(ageFrom, ageTo)
                .stream()
                .map(petMapper::mapPetToDto)
                .collect(Collectors.toList());
    }

    public List<PetDto> searchByWeight(Double weightFrom, Double weightTo) {
        return petRepository.findAllByWeightBetween(weightFrom, weightTo)
                .stream()
                .map(petMapper::mapPetToDto)
                .collect(Collectors.toList());
    }

    public List<Pet> searchByMaxWeight(Double weightMax) {
        return petRepository.findAllByWeightIsLessThanEqual(weightMax);
    }

    public boolean delete(Long id) {
        petRepository.deleteById(id);
        return true;
    }

    public boolean update(PetUpdateRequest updateRequest) {
        Optional<Pet> petOptional = petRepository.findById(updateRequest.getId());
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();

            if (updateRequest.getNewName() != null) {
                pet.setName(updateRequest.getNewName());
            }
            if (updateRequest.getNewRace() != null) {
                pet.setRace(updateRequest.getNewRace());
            }
            if (updateRequest.getNewOwner() != null) {
                pet.setOwnerName(updateRequest.getNewOwner());
            }
            if (updateRequest.getNewAge() != null) {
                pet.setAge(updateRequest.getNewAge());
            }
            petRepository.save(pet);
            return true;
        }
        return false;
    }
}
