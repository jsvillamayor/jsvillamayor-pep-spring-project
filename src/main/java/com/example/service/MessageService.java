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

    public Message getMessageById(Integer id){
        return messageRepository.findMessageByMessageId(id);
    }

    public Integer deleteMessage(Integer messageId){
        if(messageRepository.findById(messageId).isPresent()){
            messageRepository.deleteById(messageId);
            return 1;
        }
        return null;
    }

    public Integer updateMessage(Message message, long messageId){
        messageRepository.save(message);
        return 1;
    }

    public boolean messageExists(Integer messageId){
        return messageRepository.existsById(messageId);
    }

    public List<Message> getMessagesByUser(Integer accountId){
        return messageRepository.findMessagesByPostedBy(accountId);
    }

}
