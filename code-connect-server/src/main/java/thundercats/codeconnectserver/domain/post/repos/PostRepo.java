package thundercats.codeconnectserver.domain.post.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByProfile(UserProfile user);
    List<Post> findByGroup(Group group);

}
