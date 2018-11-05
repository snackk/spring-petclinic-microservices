package org.springframework.message.utils.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.message.utils.config.dto.VetStatusDTO;

public class Sender {

    @Value("${kafka.topic.json}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, VetStatusDTO> kafkaTemplate;

    public void send(VetStatusDTO vetStatusDTO) {
        kafkaTemplate.send(jsonTopic, vetStatusDTO);
    }
}
