package org.springframework.message.utils.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.message.utils.config.dto.VetStatusDTO;

import java.util.concurrent.CountDownLatch;

public class VetStatusConsumerService {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.vetstatus}")
    public void receive(VetStatusDTO vetStatusDTO) {
        latch.countDown();
    }
}
