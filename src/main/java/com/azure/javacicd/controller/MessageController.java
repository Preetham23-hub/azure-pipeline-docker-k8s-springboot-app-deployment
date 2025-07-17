package com.azure.javacicd.controller;

import com.azure.javacicd.entity.Message;
import com.azure.javacicd.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String home(){
        return "Welcome to Java CICD with Azure";
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messageService.getMessages();
    }
}
