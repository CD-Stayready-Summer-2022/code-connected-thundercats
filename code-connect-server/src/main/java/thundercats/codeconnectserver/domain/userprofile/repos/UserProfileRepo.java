package thundercats.codeconnectserver.domain.userprofile.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);
    Optional<UserProfile>findByName(String firstName, String lastName);
    Optional<Group> findByGroup(String nameOfGroup);
}
