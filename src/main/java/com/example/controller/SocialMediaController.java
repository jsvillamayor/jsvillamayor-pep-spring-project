package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    AccountService accountService;
    MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        if(account.getUsername().isBlank() || account.getUsername().length() < 5){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(accountService.addAccount(account));
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Account verifyAccount(@RequestBody Account account){
        return accountService.verifyAccount(account);
    }

    @PostMapping(value = "/messages")
    @ResponseBody
    public Message addMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }

    @GetMapping(value = "/messages")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @DeleteMapping(value = "/messages/{messageId}")
    public Message deleteMessage(@PathVariable Integer messageId){
        return messageService.deleteMessage(messageId);
    }

    @PutMapping(value = "/messages/{messageId}")
    public Message updateMessage(@RequestBody Message message, @PathVariable Integer messageId){
        return messageService.updateMessage(message, messageId);
    }

    @GetMapping(value = "/accounts/{accountId}/messages")
    public List<Message> getMessagesByUserId(@PathVariable Integer accountId){
        return messageService.getMessagesByUser(accountId);
    }

}
