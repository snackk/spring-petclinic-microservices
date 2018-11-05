package org.springframework.message.utils.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.message.utils.config.dto.VetStatusDTO;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kakfa.topic.json}")
    public void receive(VetStatusDTO vetStatusDTO) {
        latch.countDown();
    }
}
