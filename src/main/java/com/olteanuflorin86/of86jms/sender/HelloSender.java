package com.olteanuflorin86.of86jms.sender;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.olteanuflorin86.of86jms.model.HelloWorldMessage;
import com.olteanuflorin86.of86jms.config.JmsConfig;

@RequiredArgsConstructor
@Component
public class HelloSender {
	
	private final JmsTemplate jmsTemplate;

	@Scheduled(fixedRate = 2000)
	public void sendMessage() {
		
		System.out.println("I'm sending a message");
		
		HelloWorldMessage message = HelloWorldMessage
				.builder()
				.id(UUID.randomUUID())
				.message("Hello World!")
				.build();
		
		jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
		
		System.out.println("Message Sent!");
	}
	
}
