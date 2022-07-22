package thundercats.codeconnectserver.domain.group.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import thundercats.codeconnectserver.domain.post.models.Post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nameOfGroup;
    @NonNull
    private Long groupOwner;
    @NonNull
    private List<Long> users;
    private List<Post> groupPosts;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", nameOfGroup='" + nameOfGroup + '\'' +
                ", groupOwner=" + groupOwner +
                ", users=" + users +
                ", groupPosts=" + groupPosts +
                '}';
    }
}
