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
    private String content;
    private UserProfile userProfile;
    private Post post;

    public Comment(){
    }

    private String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
            return String.format("%d %s %s %s", id, content, userProfile, post);
        }
    }



