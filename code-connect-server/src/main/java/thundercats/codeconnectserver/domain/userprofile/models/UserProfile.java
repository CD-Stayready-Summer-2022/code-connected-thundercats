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


import javax.persistence.*;

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

    //private Education education;

    //private Experience experience;

    //public List<Post> posts;

//    public List<Long> follower;
//
//    public List<Long> following;
//
//    public List<Long> followRequests;

    //public List<Group> group;

    public static void save(UserProfile unfollowedUser) {}

    //public List<Message> messages;

}


