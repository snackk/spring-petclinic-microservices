package org.springframework.samples.petclinic.visits.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.samples.petclinic.visits.config.dto.VetStatusDTO;
import org.springframework.samples.petclinic.visits.model.VisitRepository;

public class VetStatusConsumerService {

    final static Logger LOG = Logger.getLogger(VetStatusConsumerService.class);

    @Autowired
    private VisitRepository visitRepository;

    @Value("${kafka.topic.vetstatus}")
    private String vetStatusTopic;

    @KafkaListener(topics = "${kafka.topic.vetstatus}")
    public void receive(VetStatusDTO vetStatusDTO) {
        LOG.info("Consumed vetStatus {" + vetStatusDTO.toString() + "} from topic {" + vetStatusTopic + "}");
        visitRepository.findById(vetStatusDTO.getId()).stream()
            .forEach(visit ->
            {
                visit.setCancelled(!vetStatusDTO.isStatus());
                visitRepository.save(visit);
            });
    }
}

