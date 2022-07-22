package thundercats.codeconnectserver.domain.message.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.message.services.MessageService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        message = messageService.create(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messages = messageService.getAll();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable  Long id) throws ResourceNotFoundException {
        Message message = messageService.getById(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/messages/{receivingUserId}")
    public ResponseEntity<List<Message>> getMessagesByReceivingUserId(@PathVariable  Long receivingUserId) {
        List<Message> messages = messageService.getByReceivingUserId(receivingUserId);
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMessage(@PathVariable Long id) throws ResourceNotFoundException {
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
