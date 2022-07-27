package thundercats.codeconnectserver.domain.post.services;

import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;

@Service
public interface PostService {

    Post create(Long user_id, Post post);
    Post getById(Long postId) throws ResourceNotFoundException;
    List<Post> getAllFromUser(Long user_id);
    List<Post> getAll();
    Post update(Long postId, Post postDetails) throws ResourceNotFoundException;
    void delete(Long postId) throws ResourceNotFoundException;
}
