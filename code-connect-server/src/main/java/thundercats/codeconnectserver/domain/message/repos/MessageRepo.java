package thundercats.codeconnectserver.domain.message.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import thundercats.codeconnectserver.domain.message.models.Message;

import java.util.Optional;

public interface MessageRepo extends JpaRepository<Message, Long> {
    Optional<Message> findByRecievingUser(Long receivingUser);
}
