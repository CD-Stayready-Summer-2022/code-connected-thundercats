package thundercats.codeconnectserver.domain.userprofile.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceCreationException;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.post.models.Post;
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
    public Boolean doesExist(String id) {
        Optional<UserProfile> optional = userProfileRepo.findById(Long.valueOf(id));
        return optional.isPresent();
    }

    @Override
    public UserProfile getById(Long id) throws ResourceNotFoundException {
        return userProfileRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No User with id:" + id));
    }

    @Override
    public UserProfile getByEmail(String email) throws ResourceNotFoundException {
        return userProfileRepo.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("No User with email:" + email));
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
        userProfileRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No User Profile with id:"+id));
        UserProfile userProfile = getById(id);
        userProfileRepo.delete(userProfile);

    }

    @Override
    public void followUser(Long followingId, Long followerId) throws ResourceNotFoundException {

    }

    @Override
    public void unfollowUser(Long unfollowingId, Long unfollowedId) throws ResourceNotFoundException {

    }

//    @Override
//    public void followUser(Long followingId, Long followerId) throws ResourceNotFoundException {
//        Optional<UserProfile> FollowedUser = Optional.of(userProfileRepo.findById(followingId)
//                .orElseThrow(()-> new ResourceNotFoundException("No User Profile with id:"+ followingId)));
//        Optional<UserProfile> Follower = Optional.of(userProfileRepo.findById(followerId)
//                .orElseThrow(()-> new ResourceNotFoundException("No User Profile with id:"+ followingId)));
//
//        UserProfile followedUser = FollowedUser.get();
//        UserProfile follower = Follower.get();
//
//        List<Long> followerList = followedUser.getFollower();
//        if(followerList == null){
//            followerList = new ArrayList<>();
//        }
//        followerList.add(follower.getId());
//        followedUser.setFollower(followerList);
//
//        List<Long> followingList = follower.getFollowing();
//        if(followingList == null){
//            followingList = new ArrayList<>();
//        }
//        followingList.add(followedUser.getId());
//        follower.setFollowing(followingList);
//
//        UserProfile.save(followedUser);
//        UserProfile.save(follower);
//    }
//    @Override
//    public void unfollowUser(Long unfollowingId, Long unfollowedId) throws ResourceNotFoundException {
//
//        Optional<UserProfile> UnFollowedUser = Optional.of(userProfileRepo.findById(unfollowingId)
//                .orElseThrow(()-> new ResourceNotFoundException("No User Profile with id:"+ unfollowingId)));
//        Optional<UserProfile> UnFollower = Optional.of(userProfileRepo.findById(unfollowedId)
//                .orElseThrow(()-> new ResourceNotFoundException("No User Profile with id:"+ unfollowingId)));
//
//        UserProfile unfollowedUser = UnFollowedUser.get();
//        UserProfile unfollower = UnFollower.get();
//
//        List<Long> followerList = unfollowedUser.getFollower();
//        if(followerList == null){
//            followerList = new ArrayList<>();
//        }
//        followerList.remove(unfollower.getId());
//        unfollowedUser.setFollower(followerList);
//
//        List<Long> followingList = unfollower.getFollowing();
//        if(followingList == null){
//            followingList = new ArrayList<>();
//        }
//        followingList.remove(unfollowedUser.getId());
//        unfollower.setFollowing(followingList);
//
//        UserProfile.save(unfollowedUser);
//        UserProfile.save(unfollower);
//    }

    @Override
    public UserProfile searchForUserByName(String firstName, String lastName) throws ResourceNotFoundException{
        return userProfileRepo.findByFirstNameAndLastName(firstName,lastName)
                .orElseThrow(()-> new ResourceNotFoundException("No User with name:" + firstName+lastName));
    }
    @Override
    public Group searchForGroupByName(String nameOfGroup) throws ResourceNotFoundException{
        return userProfileRepo.findByOwnedGroup(nameOfGroup)
                .orElseThrow(()-> new ResourceNotFoundException("No Group with name:" + nameOfGroup));
    }

    @Override
    public void followGroup(Group group) throws ResourceNotFoundException {

    }
    @Override
    public void unfollowGroup(Group group) throws ResourceNotFoundException {


    }

    @Override
    public void likePost(Post post) throws ResourceNotFoundException {

    }

    @Override
    public void unlikePost(Post post) throws ResourceNotFoundException {

    }

    @Override
    public void acceptFollowRequest(Integer number) throws ResourceNotFoundException{

    }
    @Override
    public void denyFollowRequest(Integer number) throws ResourceNotFoundException{

    }


}

