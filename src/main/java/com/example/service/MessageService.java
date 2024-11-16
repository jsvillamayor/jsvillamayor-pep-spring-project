package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
@Transactional
public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message addMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public Message getMessageById(long id){
        return messageRepository.getById(id);
    }

    public Message deleteMessage(long messageId){
        Message deletedMessage = messageRepository.getById(messageId);
        messageRepository.deleteById(messageId);
        return deletedMessage;
    }

    public Message updateMessage(Message message, long messageId){
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByUser(long accountId){
        return messageRepository.findMessagesByPostedBy(accountId);
    }

}
