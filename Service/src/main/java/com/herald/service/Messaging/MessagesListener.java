package com.herald.service.Messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herald.service.Messaging.Transfer.MessageFromHandler;
import com.herald.service.Messaging.Transfer.MessageToHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessagesListener {
    private MessagesListener(MessageService messageService, ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.objectMapper = objectMapper;
    }

    private final MessageService messageService;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${app.rabbitmq.to_service_queue}")
    public void receiveMessageFromHandler(String message) throws JsonProcessingException {
        MessageFromHandler msg = objectMapper.readValue(message, MessageFromHandler.class);
        System.out.println("Received message from handler: " + msg);
        messageService.send_to_handler(new MessageToHandler(msg.social(),msg.user_id(),msg.method(),msg.arg1()));
    }
}
