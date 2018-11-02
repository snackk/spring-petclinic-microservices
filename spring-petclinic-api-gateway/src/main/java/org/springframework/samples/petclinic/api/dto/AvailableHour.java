package org.springframework.samples.petclinic.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author Diogo Santos
 */
@Data
public class AvailableHour {

    private LocalDateTime timeDate;

}
