package thundercats.codeconnectserver.domain.userprofile.services;

import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;


public interface UserProfileService {
    UserProfile create(UserProfile userProfile) throws ResourceCreationException;
    Boolean doesExist(String id);
    UserProfile getById(Long id) throws ResourceNotFoundException;
    UserProfile getByEmail(String email) throws ResourceNotFoundException;
    List<UserProfile> getAllUserProfiles();
    UserProfile update(Long id, UserProfile userProfileDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
    //UserProfile followUser(Long followingId, Long followerId) throws ResourceNotFoundException;
    //UserProfile unfollowUser(Long unfollowingId, Long unfollowedId) throws ResourceNotFoundException;
    UserProfile searchForUserByName(String firstName, String lastName) throws ResourceNotFoundException;
    Group searchForGroupByName(String nameOfGroup) throws ResourceNotFoundException;
    void followGroup(String nameOfGroup, Long followingId) throws ResourceNotFoundException;
    void unfollowGroup(String nameOfGroup, Long unfollowingId) throws ResourceNotFoundException;
    void likePost(Post post) throws ResourceNotFoundException;
    void unlikePost(Post post) throws ResourceNotFoundException;
    void acceptFollowRequest(Integer number) throws ResourceNotFoundException;
    void denyFollowRequest(Integer number) throws ResourceNotFoundException;


}
