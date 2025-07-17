package com.azure.javacicd.controller;

import com.azure.javacicd.entity.Message;
import com.azure.javacicd.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @Test
    public void testGetMessages() throws Exception {
        Message message1 = new Message("Test message 1");
        Message message2 = new Message("Test message 2");
        List<Message> messages = Arrays.asList(message1, message2);

        when(messageService.getMessages()).thenReturn(messages);

        mockMvc.perform(get("/messages"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'content':'Test message 1'},{'content':'Test message 2'}]"));
    }
}
