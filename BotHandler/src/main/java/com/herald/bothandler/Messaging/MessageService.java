package com.herald.bothandler.Messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herald.bothandler.Messaging.Transfer.MessageToBots;
import com.herald.bothandler.Messaging.Transfer.MessageToService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {
    @Value("${app.rabbitmq.to_service_queue}")
    private String toServiceQueue;

    @Value("${app.rabbitmq.to_bots_exchange}")
    private String toBotsExchange;

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    private MessageService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    Logger log = LoggerFactory.getLogger(MessageService.class);

    public Optional<String> objToJson(Object obj) {
        try {
            String objJackson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            return Optional.of(objJackson);
        } catch (JsonProcessingException e) {
            log.error("failed conversion: Object to Json", e);
        }
        return Optional.empty();
    }

    public void send_to_service(MessageToService message) {
        var msg_json = objToJson(message);
        if (msg_json.isPresent()) {
            Message msg = MessageBuilder.withBody(msg_json.get().getBytes())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .build();
            rabbitTemplate.send(toServiceQueue, msg);
        } else {
            log.warn("Message was not sent to service: {}", message.toString());
        }
    }

    public void send_to_bots(MessageToBots message) {
        var msg_json = objToJson(message);
        if (msg_json.isPresent()) {
            Message msg = MessageBuilder.withBody(msg_json.get().getBytes())
                    .setHeader("social", message.social())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .build();
            rabbitTemplate.send(toBotsExchange, "", msg);
        } else {
            log.warn("Message was not sent to bots: {}", message.toString());
        }
    }
}
