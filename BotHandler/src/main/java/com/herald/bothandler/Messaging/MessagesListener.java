package com.herald.bothandler.Messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herald.bothandler.Messaging.Transfer.MessageFromBots;
import com.herald.bothandler.Messaging.Transfer.MessageFromService;
import com.herald.bothandler.Messaging.Transfer.MessageToBots;
import com.herald.bothandler.Messaging.Transfer.MessageToService;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessagesListener {
    private MessagesListener(MessageService messageService, ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.objectMapper = objectMapper;
    }

    private final MessageService messageService;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "${app.rabbitmq.from_bots_queue}")
    public void receiveMessageFromBots(String message) {
        MessageFromBots msg = objectMapper.convertValue(message, MessageFromBots.class);
        System.out.println("Received message from bot: " + msg);
        messageService.send_to_service(new MessageToService(msg.social(), msg.user_id(), "ping-pong", msg.content(), null, null, null,null));
    }
    @RabbitListener(queues = "${app.rabbitmq.from_service_queue}")
    public void receiveMessageFromService(String message) {
        MessageFromService msg = objectMapper.convertValue(message, MessageFromService.class);
        System.out.println("Received message from service: " + msg);
        messageService.send_to_bots(new MessageToBots(msg.social(), msg.user_id(), msg.content()));
    }
    @Value("${templates.some_string_value}")
    private String someStringValue;
    @PostConstruct
    private void startPingPong(){
        System.out.println("Ping-pong started");
        messageService.send_to_service(new MessageToService("telegram", "some_user", "ping-pong",someStringValue , null, null, null,null));
    }
}
