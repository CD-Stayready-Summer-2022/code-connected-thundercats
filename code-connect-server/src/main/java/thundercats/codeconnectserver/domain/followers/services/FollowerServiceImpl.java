package thundercats.codeconnectserver.domain.followers.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.followers.repos.FollowerRepo;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.repos.UserProfileRepo;
import thundercats.codeconnectserver.security.utils.SecurityService;

@Service
public class FollowerServiceImpl {
    @Autowired
    FollowerRepo followerRepo;
    @Autowired
    UserProfileRepo userProfileRepo;
    @Autowired
    SecurityService securityService;
// reference uses modelmapper and DTO, doesn't work for the functions
    public void save(UserProfile userProfile01, long id) throws ResourceNotFoundException{

    }
}
