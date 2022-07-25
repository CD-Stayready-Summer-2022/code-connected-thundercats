package thundercats.codeconnectserver.domain.post.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.post.repos.PostRepo;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.userprofile.services.UserProfileService;


import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private PostRepo postRepo;

    // Isn't used now, might use once userProfileService getById is implemented
    //  so that create can take an id and path variable in controller
    private UserProfileService userProfileService;

    @Autowired
    public PostServiceImpl(PostRepo postRepo, UserProfileService userProfileService) {
        this.postRepo = postRepo;
        this.userProfileService = userProfileService;
    }

    @Override
    public Post create(UserProfile user, Post post) {
        post.setPublisher(user);
        return postRepo.save(post);
    }

    @Override
    public Post getById(Long postId) throws ResourceNotFoundException {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isEmpty()) {
            throw new ResourceNotFoundException("Post not found with id: " + postId);
        }
        return post.get();
    }

    @Override
    public List<Post> getAllFromUser(UserProfile user) {
        return postRepo.findByPublisher(user);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    // Potentially change second argument to a String to just
    //  update the content since likes, comments won't change etc.
    @Override
    public Post update(Long postId, Post postDetails) throws ResourceNotFoundException {
        Post post = getById(postId);
        post.setContent(postDetails.getContent());
        post.setLikes(postDetails.getLikes());
        post.setComments(postDetails.getComments());
        return postRepo.save(post);
    }

    @Override
    public void delete(Long postId) throws ResourceNotFoundException {
        Post post = getById(postId);
        postRepo.delete(post);
    }
}
