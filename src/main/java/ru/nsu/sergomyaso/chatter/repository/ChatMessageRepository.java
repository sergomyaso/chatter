package ru.nsu.sergomyaso.chatter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import ru.nsu.sergomyaso.chatter.model.ChatMessage;

@Component
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}
