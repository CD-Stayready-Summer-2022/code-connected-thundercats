package thundercats.codeconnectserver.domain.userprofile.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.repos.UserProfileRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    private UserProfileRepo userProfileRepo;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepo userProfileRepo){
        this.userProfileRepo = userProfileRepo;
    }

    @Override
    public UserProfile create(UserProfile userProfile) throws ResourceCreationException {
        Optional<UserProfile> optional = userProfileRepo.findByEmail(userProfile.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("User with email exists " + userProfile.getEmail());
        return userProfileRepo.save(userProfile);
    }

    @Override
    public UserProfile getById(Long id) throws ResourceNotFoundException {
        return userProfileRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No User with id:" + id));
    }

    @Override
    public UserProfile getByEmail(String email) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepo.findAll();
    }

    @Override
    public UserProfile update(Long id, UserProfile userProfileDetail) throws ResourceNotFoundException {
        UserProfile savedUserProfile = getById(id);
        savedUserProfile.setFirstName(userProfileDetail.getFirstName());
        savedUserProfile.setLastName(userProfileDetail.getLastName());
        savedUserProfile.setEmail(userProfileDetail.getEmail());
        //savedUserProfile.setEducation(userProfileDetail.getEducation());
        savedUserProfile.setSkills(userProfileDetail.getSkills());
        savedUserProfile.setAccomplishments(userProfileDetail.getAccomplishments());
        return userProfileRepo.save(savedUserProfile);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        UserProfile userProfile = getById(id);
        userProfileRepo.delete(userProfile);
    }

    @Override
    public void followUser(Long followingId, Long followerId) throws ResourceNotFoundException {

    }

    @Override
    public void unfollowUser(Long unfollowingId, Long unfollowedId) throws ResourceNotFoundException {
    }
}

