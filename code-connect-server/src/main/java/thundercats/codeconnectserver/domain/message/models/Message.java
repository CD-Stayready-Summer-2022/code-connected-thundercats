package thundercats.codeconnectserver.domain.message.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import thundercats.codeconnectserver.domain.UserProfile.models.UserProfile;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
    private Long receivingUserId;
    @NonNull
    private Long sendingUserId;
    @NonNull
    private String content;

    @NonNull
    Date date = new Date();

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s", id, receivingUserId, sendingUserId, content, date);
    }

    @PrePersist
    protected void onCreate(){
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        dateFormat.format(date);
    }
}
