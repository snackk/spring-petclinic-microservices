package org.springframework.samples.petclinic.api.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diogo Santos
 */
@Data
public class Vet {

    private int id;

    private String firstName;

    private String lastName;

    private boolean status;

    private final List<AvailableHour> availableHours = new ArrayList<>();

    private final List<Speciality> specialties = new ArrayList<>();
}
