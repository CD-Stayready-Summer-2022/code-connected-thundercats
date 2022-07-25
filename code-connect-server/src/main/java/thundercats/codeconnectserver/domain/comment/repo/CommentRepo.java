package thundercats.codeconnectserver.domain.comment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import thundercats.codeconnectserver.domain.comment.model.Comment;
import thundercats.codeconnectserver.domain.post.models.Post;
import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);
}
