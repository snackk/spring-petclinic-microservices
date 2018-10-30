/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.visits.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 * @author Maciej Szarlinski
 */
@Entity
@Table(name = "visits")
@Builder(builderMethodName = "visit")
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    @Size(max = 8192)
    @Column(name = "description")
    private String description;

    @Column(name = "pet_id")
    private int petId;

    @Column(name = "vet_id")
    private int vetId;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(final int petId) {
        this.petId = petId;
    }

    public int getVetId() {
        return vetId;
    }

    public void setVetId(final int vetId) {
        this.vetId = vetId;
    }
}
