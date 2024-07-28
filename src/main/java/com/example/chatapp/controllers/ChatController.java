package com.example.chatapp.controllers;

import com.example.chatapp.entity.Message;
import com.example.chatapp.entity.User;
import com.example.chatapp.services.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private ChatService chatService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(chatService.registerUser(user));
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        return ResponseEntity.ok(chatService.sendMessage(message));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return ResponseEntity.ok(chatService.getMessages(senderId, receiverId));
    }
}

