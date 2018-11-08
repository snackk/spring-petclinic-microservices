package org.springframework.samples.petclinic.vets.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.samples.petclinic.vets.config.dto.VetStatusDTO;

public class VetStatusProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VetStatusProducerService.class);

    @Value("${kafka.topic.vetstatus}")
    private String vetStatusTopic;

    @Autowired
    private KafkaTemplate<String, VetStatusDTO> kafkaTemplate;

    public void sendMessage(VetStatusDTO vetStatusDTO) {
        LOGGER.info("vet DTO='{}'", vetStatusDTO.toString());
        kafkaTemplate.send(vetStatusTopic, vetStatusDTO);
    }
}
