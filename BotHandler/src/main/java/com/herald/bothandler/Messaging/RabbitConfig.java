package com.herald.bothandler.Messaging;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class RabbitConfig
{
    @Value("${app.rabbitmq.to_service_queue}")
    private String toServiceQueue;

    @Value("${app.rabbitmq.to_bots_exchange}")
    private String toBotsExchange;

    @Value("${app.rabbitmq.to_bots_queue_telegram}")
    private String toBotsQueueTelegram;

    @Value("${app.rabbitmq.from_bots_queue}")
    private String fromBotsQueue;

    @Value("${app.rabbitmq.from_service_queue}")
    private String fromServiceQueue;

    @Bean
    public Queue queueToService(){
        return new Queue(toServiceQueue, true,false,false);
    }
    @Bean
    public Exchange exchangeToBots(){
        return new HeadersExchange(toBotsExchange,true,false);
    }
    @Bean
    public Queue queueToBotsTelegram(){
        return new Queue(toBotsQueueTelegram,true,false,false);
    }
    @Bean
    public Queue queueFromBots(){
        return new Queue(fromBotsQueue,true,false,false);
    }
    @Bean
    public Queue queueFromService(){
        return new Queue(fromServiceQueue,true,false,false);
    }
    @Bean
    public Binding queueToBotsTelegramBinding(Exchange exchangeToBots, Queue queueToBotsTelegram){
        var params = new HashMap<String,Object>();
        params.put("x-match", "all");
        params.put("social", "telegram");
        return BindingBuilder.bind(queueToBotsTelegram).to(exchangeToBots).with("").and(params);
    }

    /*
    @Bean
    public Queue queueToBotsAll(){
        return new Queue("to_bots_all",true,false,false);
    }
    @Bean
    public Binding queueToBotsAllBinding(Exchange exchangeToBots, Queue queueToBotsAll){
        return BindingBuilder.bind(queueToBotsAll).to(exchangeToBots).with("").noargs();
    }*/
}
