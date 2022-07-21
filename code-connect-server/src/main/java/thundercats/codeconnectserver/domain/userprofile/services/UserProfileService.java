package thundercats.codeconnectserver.domain.userprofile.services;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;


public interface UserProfileService {
    UserProfile create(UserProfile userProfile);
    UserProfile getById(Long id);
    UserProfile getByEmail(String email);
    List<UserProfile> getAllUserProfiles();
    UserProfile update(Long id, UserProfile userProfileDetail);
    void delete(Long id);


}
