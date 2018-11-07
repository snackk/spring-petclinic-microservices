package org.springframework.message.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.message.utils.config.dto.VetStatusDTO;
import org.springframework.message.utils.service.VetStatusConsumerService;
import org.springframework.message.utils.service.VetStatusProducerService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "vet-status" }, controlledShutdown = true)
public class SpringPetclinicMessageUtilsApplicationTests {

	@Autowired
	private VetStatusProducerService vetStatusSenderService;

	@Autowired
	private VetStatusConsumerService vetStatusConsumerService;

	@Test
	public void testReceive() throws Exception {
		VetStatusDTO vetStatusDTO = new VetStatusDTO(1, false);
		vetStatusSenderService.sendMessage(vetStatusDTO);

		vetStatusConsumerService.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(vetStatusConsumerService.getLatch().getCount()).isEqualTo(0);
	}

}
