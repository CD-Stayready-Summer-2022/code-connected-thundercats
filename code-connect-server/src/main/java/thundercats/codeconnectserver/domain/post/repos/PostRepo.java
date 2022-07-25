package thundercats.codeconnectserver.domain.post.repos;

import org.springframework.data.jpa.repository.JpaRepository;
//import thundercats.codeconnectserver.domain.group.model.Group;
import org.springframework.stereotype.Repository;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByPublisher(UserProfile user);
    //List<Post> findByGroup(Group group);

}
