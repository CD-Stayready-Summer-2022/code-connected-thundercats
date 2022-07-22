package thundercats.codeconnectserver.domain.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.message.repos.MessageRepo;
import thundercats.codeconnectserver.domain.message.services.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @MockBean
    private MessageRepo messageRepo;

    private Message mockMessage;
    private Message savedMessage01;
    private Message savedMessage02;

    @BeforeEach
    public void setup(){
        mockMessage = new Message(1L,2L,"");

        savedMessage01 = new Message(1L,2L,"hi");
        savedMessage01.setId(1L);

        savedMessage02 = new Message(1L,2L,"hey");
        savedMessage02.setId(2L);

    }

    @Test
    @DisplayName("createMessage - success")
    public void createMessageTest01(){
        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(savedMessage01).when(messageRepo).save(mockMessage);
        Message message = messageService.create(mockMessage);
        Assertions.assertNotNull(message.getId());
    }
//    @Test
//    @DisplayName("createMessage - fail")
//    public void createMessageTest02(){
//        BDDMockito.doReturn(Optional.of(savedMessage01)).when(messageRepo).findById(ArgumentMatchers.any());
//        BDDMockito.doReturn(savedMessage01).when(messageRepo).save(mockMessage);
//        Assertions.assertThrows(ResourceCreationException.class, ()-> messageService.create(mockMessage));
//    }

    @Test
    @DisplayName("get by id - success")
    public void getByIdTest01() throws ResourceNotFoundException {
        BDDMockito.doReturn(Optional.of(savedMessage01)).when(messageRepo).findById(1L);
        Message message = messageService.getById(1L);
        Assertions.assertNotNull(message);

    }
    @Test
    @DisplayName("get by id - fail")
    public void getByIdTest02(){
        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            messageService.getById(1L);
        });
    }

    @Test
    @DisplayName("get by receiving user - success")
    public void getByReceivingUserTest01(){
        List<Message> messages = new ArrayList<>();
        messages.add(savedMessage01);
        messages.add(savedMessage02);
        BDDMockito.doReturn(messages).when(messageRepo).findByReceivingUserId(1L);
        List<Message> actualMessages = messageService.getByReceivingUserId(1L);
        Integer expected = 2;
        Integer actual = actualMessages.size();
        Assertions.assertEquals(expected, actual);
    }
//    @Test
//    @DisplayName("get by receiving - fail")
//    public void getByReceivingUserTest02() {
//        List<Message> messages = new ArrayList<>();
//        BDDMockito.doReturn(messages).when(messageRepo).findByReceivingUser(1L);
//        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
//            List<Message> actualMessage = messageService.getByReceivingUser(1L);
//        });
//    }

    @Test
    @DisplayName("get all messages - success")
    public void getAllTest01(){
        List<Message> messages = new ArrayList<>();
        messages.add(savedMessage01);
        BDDMockito.doReturn(messages).when(messageRepo).findAll();
        List<Message> actual = messageService.getAll();
        Integer expectedSize = 1;
        Integer actualSize = actual.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }
    @Test
    @DisplayName("get all messages - fail")
    public void getAllTest02(){
    }

//    @Test
//    @DisplayName("delete - success")
//    public void deleteTest01() throws ResourceNotFoundException {
//        BDDMockito.doReturn(Optional.of(savedMessage01)).when(messageRepo).findById(1L);
//        messageService.delete(1L);
//        Assertions.assertNull(messageRepo.findById(1L));
//    }
//    @Test
//    @DisplayName("delete - fail")
//    public void deleteTest02(){
//        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(1L);
//        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
//            messageService.getById(1L);
//        });
//    }
}
