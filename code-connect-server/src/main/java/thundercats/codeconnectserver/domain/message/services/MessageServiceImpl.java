package thundercats.codeconnectserver.domain.message.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.message.repos.MessageRepo;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    private MessageRepo messageRepo;
    @Autowired
    public MessageServiceImpl(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @Override
    public Message create(Message message){
        return messageRepo.save(message);
    }

    @Override
    public Message getById(Long id) throws ResourceNotFoundException{
        return messageRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Message with id: " + id));
    }

    @Override
    public List<Message> getByReceivingUserId(Long receivingUserId){
        return messageRepo.findByReceivingUserId(receivingUserId);
    }

    @Override
    public List<Message> getAll() {
        return messageRepo.findAll();
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        messageRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Message with id: " + id));
        Message message = getById(id);
        messageRepo.delete(message);
    }
}
