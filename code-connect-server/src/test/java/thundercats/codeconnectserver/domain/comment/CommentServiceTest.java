package thundercats.codeconnectserver.domain.comment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import thundercats.codeconnectserver.domain.comment.model.Comment;
import thundercats.codeconnectserver.domain.comment.repo.CommentRepo;
import thundercats.codeconnectserver.domain.comment.service.CommentService;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

@SpringBootTest
@ContextConfiguration
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @MockBean
    private CommentRepo commentRepo;

    @Test
    public void createTest01() {
        UserProfile userProfile = new UserProfile("Ana", "Bee", "ana@bee.com","N/A","N/A");
        Post post = new Post("New Post");
        Comment comment = new Comment(1L, "Content", userProfile, post);
        Comment actual = commentService.create(comment);
        Assertions.assertEquals(comment, actual);
    }
}
