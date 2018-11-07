package org.springframework.message.utils.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.message.utils.config.dto.VetStatusDTO;
import org.springframework.message.utils.service.VetStatusConsumerService;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class VetStatusConsumerConfig {

    @Value("${kafka.bootstrap-server}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "vets");

        return props;
    }

    @Bean
    public ConsumerFactory<String, VetStatusDTO> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(VetStatusDTO.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, VetStatusDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, VetStatusDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    @Bean
    public VetStatusConsumerService receiver() {
        return new VetStatusConsumerService();
    }
}