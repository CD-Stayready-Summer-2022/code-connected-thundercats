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
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.repos.UserProfileRepo;

import java.util.ArrayList;
import java.util.List;
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
    private Group savedGroup01;
    private Group savedGroup02;

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
    @Test
    @DisplayName("createUserProfile - fail")
    public void createUserProfileTest02(){

    }

    @Test
    @DisplayName("get by id - success")
    public void getByIdTest01() throws ResourceNotFoundException {
        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findById(1L);
        UserProfile userProfile = userProfileService.getById(1L);
        Assertions.assertNotNull(userProfile);

    }
    @Test
    @DisplayName("get by id - fail")
    public void getByIdTest02(){
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findById(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            userProfileService.getById(1L);
        });
    }
    @Test
    @DisplayName("get by email - success")
    public void getByEmail01() throws ResourceNotFoundException {
        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findByEmail("janedoe@gmail.com");
        UserProfile userProfile = userProfileService.getByEmail("janedoe@gmail.com");
        Assertions.assertNotNull(userProfile);
    }
    @Test
    @DisplayName("get by email - fail")
    public void getByEmail02(){
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findByEmail("janedoe@gmail.com");
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            userProfileService.getByEmail("janedoe@gmail.com");
        });
    }
    @Test
    @DisplayName("get all user profiles - success")
    public void getAllTest01(){
        List<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(savedUserProfile01);
        BDDMockito.doReturn(userProfiles).when(userProfileRepo).findAll();
        List<UserProfile> actual = userProfileService.getAllUserProfiles();
        Integer expectedSize = 1;
        Integer actualSize = actual.size();
        Assertions.assertEquals(expectedSize, actualSize);
    }
    @Test
    @DisplayName("get all user profiles - fail")
    public void getAllTest02(){

    }

    @Test
    @DisplayName("delete - success")
    public void deleteTest01() throws ResourceNotFoundException {
       BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findById(1L);
       userProfileService.delete(1L);
       Assertions.assertNull(userProfileRepo.findById(1L));
    }
   @Test
   @DisplayName("delete - fail")
   public void deleteTest02(){
      BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findById(1L);
      Assertions.assertThrows(ResourceNotFoundException.class, ()->{
          userProfileService.getById(1L);
       });
   }

//    @Test
//    @DisplayName("followUser - success")
//    public void followUserTest01() throws ResourceNotFoundException {
//        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findById(1L);
//        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findById(2L);
//        UserProfile userProfile = userProfileService.followUser(1L, 2L);
//        Assertions.assertNull(userProfile);


//    }
    @Test
    @DisplayName("followUser - fail")
    public void followUserTest02(){
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findById(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            userProfileService.getById(1L);
        });
    }

//    @Test
//    @DisplayName("unfollowUser - success")
//    public void unfollowUserTest01() throws ResourceNotFoundException {
//        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findById(1L);
//        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findById(2L);
//        UserProfile userProfile = userProfileService.unfollowUser(1L, 2L);
//        Assertions.assertNull(userProfile);

//    }
    @Test
    @DisplayName("unfollowUser - fail")
    public void unfollowUserTest02(){
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findById(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            userProfileService.getById(1L);
        });
    }

    @Test
    @DisplayName("searchForUserByName - success")
    public void searchForUserByNameTest01() throws ResourceNotFoundException {
        BDDMockito.doReturn(Optional.of(savedUserProfile01)).when(userProfileRepo).findByFirstNameAndLastName("jane", "doe");
        UserProfile userProfile = userProfileService.searchForUserByName("jane", "doe");
        Assertions.assertNotNull(userProfile);
    }

    @Test
    @DisplayName("searchForUserByName - fail")
    public void searchForUserByNameTest02(){
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findByFirstNameAndLastName("jane","doe");
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            userProfileService.searchForUserByName("jane", "doe");
        });
    }

    @Test
    @DisplayName("searchForGroupByName - success")
    public void searchForGroupByNameTest01() throws ResourceNotFoundException {
        BDDMockito.doReturn(Optional.of(savedGroup01)).when(userProfileRepo).findByOwnedGroup("doe's group");
        Group group = userProfileService.searchForGroupByName("doe's group");
        Assertions.assertNotNull(group);
    }
    @Test
    @DisplayName("searchForGroupByName - fail")
    public void searchForGroupByNameTest02(){
        BDDMockito.doReturn(Optional.empty()).when(userProfileRepo).findByOwnedGroup("doe's group");
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            userProfileService.searchForGroupByName("doe's group");
        });
    }

    @Test
    @DisplayName("followGroup - success")
    public void followGroupTest01() throws ResourceNotFoundException {

    }
    @Test
    @DisplayName("followGroup - fail")
    public void followGroupTest02(){

    }

    @Test
    @DisplayName("unfollowGroup - success")
    public void unfollowGroupTest01() throws ResourceNotFoundException {

    }
    @Test
    @DisplayName("unfollowGroup - fail")
    public void unfollowGroupTest02(){

    }

    @Test
    @DisplayName("likePost - success")
    public void likePostTest01() throws ResourceNotFoundException {

    }
    @Test
    @DisplayName("likePost - fail")
    public void likePostTest02(){

    }

    @Test
    @DisplayName("unlikePost - success")
    public void unlikePostTest01() throws ResourceNotFoundException {

    }
    @Test
    @DisplayName("unlikePost - fail")
    public void unlikePostTest02(){

    }

    @Test
    @DisplayName("acceptFollowRequest - success")
    public void acceptFollowRequestTest01() throws ResourceNotFoundException {

    }
    @Test
    @DisplayName("acceptFollowRequest - fail")
    public void acceptFollowRequestTest02(){

    }

    @Test
    @DisplayName("denyFollowRequest - success")
    public void denyFollowRequestTest01() throws ResourceNotFoundException {

    }
    @Test
    @DisplayName("denyFollowRequest - fail")
    public void denyFollowRequestTest02(){

    }
}
