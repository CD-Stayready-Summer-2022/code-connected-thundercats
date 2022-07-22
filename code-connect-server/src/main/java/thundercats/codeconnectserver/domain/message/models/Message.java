package thundercats.codeconnectserver.domain.message.models;

import lombok.*;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date now = new Date();

    private SimpleDateFormat sdf = new SimpleDateFormat ("yyyy.MM.dd 'at' hh:mm:ss");

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, recievingUser, sendingUser, content, now);
    }
}
