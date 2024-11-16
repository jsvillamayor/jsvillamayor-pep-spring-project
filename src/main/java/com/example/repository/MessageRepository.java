package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

    Boolean existsByMessageId(Integer Id);
    List<Message> findMessagesByPostedBy(Integer accountId);
    Message findMessageByMessageId(Integer messageId);

}
