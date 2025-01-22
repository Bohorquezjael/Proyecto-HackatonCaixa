package io.nuwe.technical.api.services;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
	this.messageRepository= messageRepository;
    }

    public List<Message> getAllMessages(){
	List<Message> messages = messageRepository.findAll();
	return messages;
    }

    public List<Message> getAllMessagesByUserReceiverId(long userReceiverId){
	List<Message> messages = messageRepository.findAllByUserReceiverId(userReceiverId);
	return messages;
    }

    public List<Message> getAllMessagesByUserSenderId(long userSenderId){
	List<Message> messages = messageRepository.findAllByUserSenderId(userSenderId);
	return messages;
    }

    public List<Message> getAllMessagesByUserSenderIdAndUserReceiverId(long userSenderId, long userReceiverId){
	List<Message> messages = messageRepository.findAllByUserSenderIdAndUserReceiverId(userSenderId, userReceiverId);
	return messages;
    }

    public Optional<Message> getMessageById(int id){
	Optional<Message> message = messageRepository.findById(id);
	return message;
    }

    public Message createMessage(Message u){
	messageRepository.save(u);
	return u;
    }

    public void saveMessage(Message t){
	messageRepository.save(t);
    }

    public Message deleteMessage(Message message){
	messageRepository.delete(message);
	return message;
    }

    public void deleteAll(){
	messageRepository.deleteAll();
    }
}
