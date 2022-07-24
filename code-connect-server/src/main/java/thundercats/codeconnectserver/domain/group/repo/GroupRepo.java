package thundercats.codeconnectserver.domain.group.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import thundercats.codeconnectserver.domain.group.model.Group;

public interface GroupRepo extends JpaRepository<Group, Long> {
}
