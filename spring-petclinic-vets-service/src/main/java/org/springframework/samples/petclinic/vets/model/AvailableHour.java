package org.springframework.samples.petclinic.vets.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Models a {@link AvailableHour AvailableHour} for each {@link Vet Vet}
 *
 * @author Diogo Santos
 */
@Entity
@Table(name = "available_hour")
public class AvailableHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "time_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime timeDate;

    public AvailableHour() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalDateTime timeDate) {
        this.timeDate = timeDate;
    }
}
