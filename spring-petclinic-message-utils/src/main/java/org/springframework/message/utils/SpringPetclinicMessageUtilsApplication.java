package org.springframework.message.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.message.utils.config.dto.VetStatusDTO;
import org.springframework.message.utils.service.VetStatusConsumerService;
import org.springframework.message.utils.service.VetStatusProducerService;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringPetclinicMessageUtilsApplication {

	@Autowired
	VetStatusProducerService vetStatusProducerService;

	@Autowired
	private VetStatusProducerService vetStatusSenderService;

	@Autowired
	private VetStatusConsumerService vetStatusConsumerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringPetclinicMessageUtilsApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws Exception{
		simpleSendAndReceive();
	}

	public void simpleSendAndReceive() throws Exception {
		VetStatusDTO vetStatusDTO = new VetStatusDTO(1, false);
		vetStatusSenderService.sendMessage(vetStatusDTO);

		vetStatusConsumerService.getLatch().await(10000, TimeUnit.MILLISECONDS);
		System.out.println((vetStatusConsumerService.getVetStatusDTO().toString()));
	}
}
