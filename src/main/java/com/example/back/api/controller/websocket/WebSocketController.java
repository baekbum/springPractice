package com.example.back.api.controller.websocket;

import com.example.back.api.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class WebSocketController {

    @MessageMapping("/send-message")
    @SendTo("/topic/message")
    public Message getMessage(@RequestBody Message msg) {
        return msg;
    }
}
