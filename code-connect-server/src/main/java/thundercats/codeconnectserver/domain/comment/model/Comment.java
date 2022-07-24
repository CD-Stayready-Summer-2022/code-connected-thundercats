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
    @JoinColumn(name = "user_profile_id")
    @NonNull
    private UserProfile userProfile;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @NonNull
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Post comment;

    public Post getComment() {
        return comment;
    }

    public void setComment(Post comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
            return String.format("%d %s %s %s", id, content, userProfile, post);
        }
    }