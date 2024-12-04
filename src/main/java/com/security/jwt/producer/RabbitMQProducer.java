package com.security.jwt.producer;

import com.security.jwt.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String EXCHANGE;

    @Value("${rabbitmq.routing.key}")
    private String ROUTING_KEY;

    @Value("${rabbitmq.routing.json-key}")
    private String ROUTING_JSON_KEY;


    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, message);
    }

    public void sendJsonMessage(User user) {
        LOGGER.info(String.format("JSON Message sent -> %s", user));
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_JSON_KEY, user);
    }


}
