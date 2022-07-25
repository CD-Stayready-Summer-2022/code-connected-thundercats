package thundercats.codeconnectserver.domain.post.services;

import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;

@Service
public interface PostService {

    Post create(UserProfile user, Post post);
    Post getById(Long postId) throws ResourceNotFoundException;
    List<Post> getAllFromUser(UserProfile user);
    List<Post> getAll();
    Post update(Long postId, Post postDetails) throws ResourceNotFoundException;
    void delete(Long postId) throws ResourceNotFoundException;
}
