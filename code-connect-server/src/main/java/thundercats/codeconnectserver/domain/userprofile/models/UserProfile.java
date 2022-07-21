package thundercats.codeconnectserver.domain.userprofile.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import thundercats.codeconnectserver.domain.education.Education;
import thundercats.codeconnectserver.domain.experience.Experience;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.post.models.Post;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String skills;

    @NonNull
    private String accomplishments;

    @ManyToOne
    @JoinColumn(name = "education_ID")
    private Education education;

}


