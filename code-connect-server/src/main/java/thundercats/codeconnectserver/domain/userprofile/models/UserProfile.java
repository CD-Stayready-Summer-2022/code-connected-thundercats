package thundercats.codeconnectserver.domain.userprofile.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;
import thundercats.codeconnectserver.domain.education.Education;
import thundercats.codeconnectserver.domain.experience.Experience;
import thundercats.codeconnectserver.domain.group.model.Group;
import thundercats.codeconnectserver.domain.message.models.Message;
import thundercats.codeconnectserver.domain.post.models.Post;


import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "userprofiles")
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
    private Group ownedGroup;

    @ManyToOne(cascade = CascadeType.ALL)
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    private Education education;

    @ManyToOne
    private Experience experience;

    @OneToMany
    List<Post> posts;


    List<Long> follower;

    List<Long> following;

   List<Long> followRequests;

   List<Message> messages;

    public static void save(UserProfile User) {
    }
}


