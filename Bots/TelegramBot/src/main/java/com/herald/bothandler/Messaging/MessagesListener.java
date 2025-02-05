package com.herald.bothandler.Messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herald.bothandler.Messaging.Transfer.MessageFromHandler;
import com.herald.bothandler.Messaging.Transfer.MessageToHandler;
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


    @RabbitListener(queues = "${app.rabbitmq.to_bots_queue_telegram}")
    public void receiveMessageFromHandler(String message) throws JsonProcessingException {
        MessageFromHandler msg = objectMapper.readValue(message, MessageFromHandler.class);
        System.out.println("Received message from handler: " + msg);
        messageService.send_to_handler(new MessageToHandler("telegram",msg.user_id(),msg.content()));
    }
}
