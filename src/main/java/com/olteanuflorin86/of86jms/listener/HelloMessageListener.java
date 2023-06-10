package com.olteanuflorin86.of86jms.listener;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.olteanuflorin86.of86jms.config.JmsConfig;
import com.olteanuflorin86.of86jms.model.HelloWorldMessage;

@Component
public class HelloMessageListener {

	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage,
					   @Headers MessageHeaders headers, Message message) {
		
		System.out.println("I Got a Message!!!!!");
		
		System.out.println(helloWorldMessage);
		
		// uncomment and view to see retry count in debugger
	       // throw new RuntimeException("foo");
	}
}
