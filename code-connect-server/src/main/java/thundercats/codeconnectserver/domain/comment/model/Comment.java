package thundercats.codeconnectserver.domain.comment.model;


import lombok.*;
import thundercats.codeconnectserver.domain.UserProfile.models.UserProfile;
import thundercats.codeconnectserver.domain.post.models.Post;


import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String content;
    private UserProfile userProfile;
    private Post post;

    public Comment(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id.equals(comment.id) && Objects.equals(content, comment.content) && Objects.equals(userProfile, comment.userProfile) && Objects.equals(post, comment.post);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, content, userProfile, post);
    }

    @Override
    public String toString() {
            return String.format("%d %s %s %s", id, content, userProfile, post);
        }
    }



