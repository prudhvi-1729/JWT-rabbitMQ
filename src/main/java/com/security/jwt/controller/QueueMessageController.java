package com.security.jwt.controller;

import com.security.jwt.model.User;
import com.security.jwt.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbitmq")
@RequiredArgsConstructor
public class QueueMessageController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping("/publish")
    public String sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return message;
    }

    @PostMapping("/publish-json")
    public String sendJsonMessage(@RequestBody User user) {
        rabbitMQProducer.sendJsonMessage(user);
        return user.toString();
    }
}
