package com.example.pets.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Marta Siudzińska
 */
@Data
@Entity // hibernate
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String ownerName;
    private double weight;
    private boolean pureRace;
    @Enumerated(EnumType.STRING)
    private Race race;

    public enum Race {
        LABRADOR, HUSKY, GOLDEN_RETRIEVER, MOPS, JAMNIK, CHIUHUAHUA;
    }
}
