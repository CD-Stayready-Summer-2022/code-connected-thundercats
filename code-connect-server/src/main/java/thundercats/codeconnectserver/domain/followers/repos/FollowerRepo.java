package thundercats.codeconnectserver.domain.followers.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thundercats.codeconnectserver.domain.followers.models.Follower;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;


@Repository
public interface FollowerRepo extends JpaRepository<Follower, Long> {
    boolean existsByFirstUserAndSecondUser(UserProfile first, UserProfile second);

    List<Follower> findByFirstUser(UserProfile user);
    List<Follower> findBySecondUser(UserProfile user);

}
