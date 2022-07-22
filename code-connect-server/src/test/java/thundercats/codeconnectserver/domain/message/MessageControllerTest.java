package thundercats.codeconnectserver.domain.message;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.message.services.MessageService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    private Message inputMessage;
    private Message mockMessage1;
    private Message mockMessage2;

    @BeforeEach
    public void setup(){
        inputMessage = new Message(1L,1L,"");

        mockMessage1 = new Message(1L,1L,"");
        mockMessage1.setId(1L);

        mockMessage2 = new Message(1L,1L,"");
        mockMessage2.setId(2L);
    }

    @Test
    @DisplayName("server controller accessible")
    public void PersonControllerTest01() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/message"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("Message Post(Create): /api/v1/message - success")
    public void createMessageRequestSuccess() throws Exception {
        BDDMockito.doReturn(mockMessage1).when(messageService).create(any());
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/v1/message")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonStringify.asJsonString(inputMessage)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Is.is(1)));
    }

    @Test
    @DisplayName("Message Post(Create): /api/v1/message - fail")
    public void createMessageRequestFail(){}

    @Test
    @DisplayName("Message Get All - success")
    public void getAllMessagesSuccess() throws Exception {
        //List<Message> messages = new ArrayList<>();
        BDDMockito.doReturn(List.of(mockMessage1)).when(messageService).getAll();
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/v1/message")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id[*].employeeId").isNotEmpty());
    }

    @Test
    @DisplayName("Message get by id - success")
    public void getMessageByIdTestSuccess() throws Exception{
        BDDMockito.doReturn(mockMessage1).when(messageService).getById(1L);
        mockMvc.perform(get("/api/v1/message/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }

//    @Test
//    public void getPersonByIdTestFail() throws Exception {
//        BDDMockito.doThrow(new PersonNotFoundException("Not Found")).when(mockPersonService).getPersonById(1);
//        mockMvc.perform(get("/persons/{id}", 1))
//                .andExpect(status().isNotFound());
//    }

    @Test
    @DisplayName("message delete")
    public void deleteMessageTestSuccess() throws Exception{
        BDDMockito.doNothing().when(messageService).delete(any());
        mockMvc.perform(delete("/api/v1/message/{id}", 1))
                .andExpect(status().isNoContent());
    }

}
