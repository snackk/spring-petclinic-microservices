package org.springframework.samples.petclinic.api.application;

import lombok.RequiredArgsConstructor;
import org.springframework.samples.petclinic.api.dto.Vet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Diogo Santos
 */
@Component
@RequiredArgsConstructor
public class VetsServiceClient {

    private final RestTemplate loadBalancedRestTemplate;

    public Vet getVet(final int vetId) {
        return loadBalancedRestTemplate.getForObject("http://vets-service/vets/{vetId}", Vet.class, vetId);
    }
}
