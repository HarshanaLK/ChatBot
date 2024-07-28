package com.example.chatapp.services;

import com.example.chatapp.entity.Message;
import com.example.chatapp.entity.User;
import com.example.chatapp.repositories.MessageRepository;
import com.example.chatapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ChatService {


    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Message sendMessage(Message message) {
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }
}