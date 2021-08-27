package com.example.back.api.controller.websocket;

import com.example.back.api.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

//    @MessageMapping("/send-message/{roomId}") 특정 룸에 메시지를 보내고 싶을 때때
//   @SendTo("/topic/message/{roomId}")
    @MessageMapping("/send-message")
    @SendTo("/topic/message")
    public Message getMessage(@RequestBody Message msg) {
        return msg;
    }
}
