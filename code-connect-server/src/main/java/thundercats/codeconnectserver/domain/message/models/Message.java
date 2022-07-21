package thundercats.codeconnectserver.domain.message.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Long recievingUser;
    @NonNull
    private Long sendingUser;
    @NonNull
    private String content;
    @NonNull
    private String sentTime;

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, recievingUser, sendingUser, content, sentTime);
    }
}
