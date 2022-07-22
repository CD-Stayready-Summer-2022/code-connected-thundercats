package thundercats.codeconnectserver.domain.userprofile.services;

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
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.repos.UserProfileRepo;

import java.util.Optional;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserProfileServiceImplTest {

    @Autowired
    private UserProfileService userProfileService;

    @MockBean
    private UserProfileRepo userProfileRepo;

    private UserProfile mockUserProfile;
    private UserProfile savedUserProfile01;
    private UserProfile savedUserProfile02;

    @BeforeEach
    public void setup(){
        mockUserProfile = new UserProfile("jane", "doe",
                "janedoe@gmail.com", "Marketing",
                "Marketing Award");
        savedUserProfile01 = new UserProfile("jane", "doe",
                "janedoe@gmail.com", "Marketing",
                "Marketing Award");
        savedUserProfile01.setId(1L);

        savedUserProfile02 = new UserProfile("john", "doe",
                "johndoe@gmail.com", "",
                "Marketing Award");
        savedUserProfile02.setId(2L);
    }

    @Test
    @DisplayName("createUserProfile - success")
    public void createUserProfileTest01() throws ResourceCreationException {
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(savedUserProfile01).when(userProfileRepo).save(mockUserProfile);
        UserProfile userProfile = userProfileService.create(mockUserProfile);
        System.out.println(mockUserProfile);
        Assertions.assertNotNull(userProfile.getId());
    }
}
