package thundercats.codeconnectserver.domain.post.models;

import lombok.*;
import thundercats.codeconnectserver.domain.comment.model.Comment;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserProfile publisher;

    private String content;

    @Temporal(TemporalType.DATE) // tariq used TIMESTAMP, thought this might be more relevant
    private Date created;

    @PrePersist
    public void onCreate() {
        created = new Date();
    }
    private Integer likes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment") // mappedBy may need to be changed
    private List<Comment> comments;

    public Post(String content) {
        this.content = content;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public Post(UserProfile publisher, String content) {
        this.publisher = publisher;
        this.content = content;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public Post(UserProfile publisher, String content, Integer likes, List<Comment> comments) {
        this.publisher = publisher;
        this.content = content;
        this.likes = likes;
        this.comments = comments;
    }
}
