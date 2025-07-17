package com.azure.javacicd.service;

import com.azure.javacicd.entity.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final List<Message> messages = new ArrayList<>();

    public MessageService() {
        messages.add(new Message("Hello from Azure!"));
        messages.add(new Message("Welcome to the Spring Boot application."));
    }

    public List<Message> getMessages() {
        return messages;
    }
}
