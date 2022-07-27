package thundercats.codeconnectserver.domain.message.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import thundercats.codeconnectserver.domain.message.models.Message;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findByReceiver(Long receiver);
}
