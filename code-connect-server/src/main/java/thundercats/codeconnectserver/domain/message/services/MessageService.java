package thundercats.codeconnectserver.domain.message.services;

import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.message.models.Message;

import java.util.List;

public interface MessageService {
    Message create(Message message);
    Message getById(Long id) throws ResourceNotFoundException;
    List<Message> getByReceivingUserId(Long receivingUserId);
    List<Message> getAll() ;
    void delete(Long id) throws ResourceNotFoundException;
}
