package thundercats.codeconnectserver.domain.userprofile.services;
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;


public interface UserProfileService {
    UserProfile create(UserProfile userProfile) throws ResourceCreationException;
    UserProfile getById(Long id) throws ResourceNotFoundException;
    UserProfile getByEmail(String email);
    List<UserProfile> getAllUserProfiles();
    UserProfile update(Long id, UserProfile userProfileDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;


}
