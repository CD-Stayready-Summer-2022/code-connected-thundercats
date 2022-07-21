package thundercats.codeconnectserver.domain.userprofile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.repos.UserProfileRepo;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    private UserProfileRepo userProfileRepo;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepo userProfileRepo){
        this.userProfileRepo = userProfileRepo;
    }
    @Override
    public UserProfile create(UserProfile userProfile){
        return userProfileRepo.save(userProfile);
    }

    @Override
    public UserProfile getById(Long id) throws ResourceNotFoundException {
        return UserProfileRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No User with id:" + id));
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return UserProfileRepo.findAll();
    }

    @Override
    public UserProfile update(Long id, UserProfile userProfileDetail) throws ResourceNotFoundException {
        UserProfile savedUserProfile = getById(id);
        savedUserProfile.setFirstName(userProfileDetail.getFirstName());
        savedUserProfile.setLastName(userProfileDetail.getLastName());
        savedUserProfile.setEmail(userProfileDetail.getEmail());
        savedUserProfile.setEducation(userProfileDetail.getEducation());
        savedUserProfile.setSkills(userProfileDetail.getSkills());
        savedUserProfile.setAccomplishments(userProfileDetail.getAccomplishments());
        return UserProfileRepo.save(savedUserProfile);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        UserProfile userProfile = getById(id);
        UserProfileRepo.delete(userProfile);
    }
}

