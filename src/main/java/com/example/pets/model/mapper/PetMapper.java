package com.example.pets.model.mapper;

import com.example.pets.model.Pet;
import com.example.pets.model.PetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Marta Siudzińska
 */
@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mappings({
            @Mapping(source = "name", target = "petsName"),
            @Mapping(source = "age", target = "petsAge"),
            @Mapping(source = "race", target = "race")
    })
    PetDto mapPetToDto(Pet pet);
}
