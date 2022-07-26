package thundercats.codeconnectserver.domain.userprofile.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import thundercats.codeconnectserver.domain.userprofile.controllers.UserProfileController;
import thundercats.codeconnectserver.domain.userprofile.services.UserProfileService;
import thundercats.codeconnectserver.security.PrincipalDetailsArgumentResolver;
import thundercats.codeconnectserver.security.models.FireBaseUser;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
        //@Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserProfileService service;

        @BeforeEach
        public void setUp(){
            FireBaseUser fireBaseUser = new FireBaseUser();
            fireBaseUser.setEmail("test@auser.com");
            fireBaseUser.setUid("xyz");
            mockMvc = MockMvcBuilders
                    .standaloneSetup(new UserProfileController(service))
                    .setCustomArgumentResolvers(new PrincipalDetailsArgumentResolver(fireBaseUser))
                    .build();
        }

        @Test
        public void getUserInfoTest01() throws Exception {
            BDDMockito.doReturn(true).when(service).doesExist("xyz");
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/userprofile/me"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.uid", is("xyz")))
                    .andExpect(jsonPath("$.email", is("test@auser.com")));
        }
    }