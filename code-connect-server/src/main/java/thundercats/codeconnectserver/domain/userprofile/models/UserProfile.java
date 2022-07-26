package thundercats.codeconnectserver.domain.userprofile.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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

    @OneToOne(mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Group ownedGroup;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    //@ManyToOne(cascade = CascadeType.ALL)
   // private Education education;

    //@ManyToOne
    //private Experience experience;

    @OneToMany
    List<Post> posts;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserProfile> follower;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserProfile> following;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserProfile> followRequests;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;

    public static void save(UserProfile User) {
    }
}


