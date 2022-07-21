package thundercats.codeconnectserver.domain.message;

import lombok.Data;
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
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.message.repos.MessageRepo;
import thundercats.codeconnectserver.domain.message.services.MessageService;

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

        savedMessage02 = new Message(2L,1L,"hey");
        savedMessage02.setId(2L);

    }

    @Test
    @DisplayName("createMessage - success")
    public void createMessageTest01(){
        BDDMockito.doReturn(Optional.empty()).when(messageRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(savedMessage01).when(messageRepo).save(mockMessage);
        Message message = messageService.create(mockMessage);
        System.out.println(mockMessage);
        Assertions.assertNotNull(message.getId());
    }
    @Test
    @DisplayName("createMessage - fail")
    public void createMessageTest02(){

    }
}
