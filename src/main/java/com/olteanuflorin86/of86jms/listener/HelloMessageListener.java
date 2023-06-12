package com.olteanuflorin86.of86jms.listener;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.olteanuflorin86.of86jms.config.JmsConfig;
import com.olteanuflorin86.of86jms.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloMessageListener {
	
	private final JmsTemplate jmsTemplate;

	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage,
					   @Headers MessageHeaders headers, Message message) {
		
//		System.out.println("I Got a Message!!!!!");
		
//		System.out.println(helloWorldMessage);
		
		// uncomment and view to see retry count in debugger
//	    throw new RuntimeException("foo");
	}
	
	@JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {
//					   @Headers MessageHeaders headers, Message jmsMessage,
//					      org.springframework.messaging.Message springMessage) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);
        //example to use Spring Message type
        // jmsTemplate.convertAndSend((Destination) springMessage.getHeaders().get("jms_replyTo"), "got it!");

    }
	
}


