package com.security.jwt.consumer;

import com.security.jwt.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s", message));
    }


    @RabbitListener(queues = "${rabbitmq.json.queue}")
    public void consumeJson(User user) {
        LOGGER.info(String.format("JSON Message received -> %s", user.toString() ));
    }
}
