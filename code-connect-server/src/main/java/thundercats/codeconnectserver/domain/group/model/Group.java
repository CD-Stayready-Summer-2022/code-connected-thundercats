package thundercats.codeconnectserver.domain.group.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nameOfGroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group") // mappedBy may need to be changed
    private List<UserProfile> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Post> groupPosts;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", nameOfGroup='" + nameOfGroup + '\'' +
                //", owner=" + owner +
                //", users=" + users +
                ", groupPosts=" + groupPosts +
                '}';
    }
}