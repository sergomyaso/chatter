package ru.nsu.sergomyaso.chatter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.sergomyaso.chatter.model.ChatMessage;
import ru.nsu.sergomyaso.chatter.repository.ChatMessageRepository;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public void saveChatMessage(ChatMessage message) {
        this.chatMessageRepository.save(message);
    }

    public List<ChatMessage> getListMessages() {
        return this.chatMessageRepository.findAll();
    }


}
