package thundercats.codeconnectserver.domain.comment.model;


import lombok.*;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;
import thundercats.codeconnectserver.domain.post.models.Post;


import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "comments")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String content;

    @ManyToOne
    private Post post;

    public Comment(long l, String content, UserProfile userProfile, Post post) {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public String toString() {
            return String.format("%d %s %s", id, content, post);
        }
    }