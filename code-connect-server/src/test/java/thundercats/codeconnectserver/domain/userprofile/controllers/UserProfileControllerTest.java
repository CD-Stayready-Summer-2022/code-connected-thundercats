package thundercats.codeconnectserver.domain.userprofile.controllers;

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
import thundercats.codeconnectserver.domain.message.JsonStringify;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.repos.UserProfileRepo;
import thundercats.codeconnectserver.domain.userprofile.services.UserProfileService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    private UserProfile inputUserProfile;
    private UserProfile mockUserProfile01;
    private UserProfile mockUserProfile02;

    @BeforeEach
    public void setup(){
        inputUserProfile = new UserProfile("jane", "doe",
                "janedoe@gmail.com", "Marketing",
                "Marketing Award");
        mockUserProfile01 = new UserProfile("jane", "doe",
                "janedoe@gmail.com", "Marketing",
                "Marketing Award");
        mockUserProfile01.setId(1L);

        mockUserProfile02 = new UserProfile("john", "doe",
                "johndoe@gmail.com", "",
                "Marketing Award");
        mockUserProfile02.setId(2L);
    }
    @Test
    @DisplayName("server controller accessible")
    public void UserProfileControllerTest01() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/userprofile"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }
    @Test
    @DisplayName("User Profile(Create): /api/v1/userprofile - success")
    public void createUserProfileSuccess() throws Exception {
        BDDMockito.doReturn(mockUserProfile01).when(userProfileService).create(any());
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/v1/userprofile")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonStringify.asJsonString(inputUserProfile)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
    }
    @Test
    @DisplayName("User Profile(Create): /api/v1/userprofile - fail")
    public void createUserProfileFail(){}

    @Test
    @DisplayName("userProfile Get All - success")
    public void getAllUserProfilesSuccess() throws Exception {
        BDDMockito.doReturn(List.of(mockUserProfile01)).when(userProfileService).getAllUserProfiles();
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/api/v1/userprofile")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("user profile delete")
    public void deleteUserProfileTestSuccess() throws Exception{
        BDDMockito.doNothing().when(userProfileService).delete(any());
        mockMvc.perform(delete("/api/v1/userprofile/{id}", 1))
                .andExpect(status().isNoContent());
    }


}
