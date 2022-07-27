package thundercats.codeconnectserver.domain.post.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.post.repos.PostRepo;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Run tests to check after all entities created //
// Won't run without userProfile and Comment being an @Entity //
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostRepo postRepo;

    private Post mockPost01;
    private Post savedPost01;
    private Post savedPost02;

    @BeforeEach
    public void setUp() {
        mockPost01 = new Post(new UserProfile(), "This is a post", 5, new ArrayList<>());
        mockPost01.getPublisher().setId(1L);

        savedPost01 = new Post(new UserProfile(), "This is a post", 5, new ArrayList<>());
        savedPost01.setId(1L);
        savedPost01.getPublisher().setId(1L);

        savedPost02 = new Post(null, "Postssdsda", 500, new ArrayList<>());
        savedPost02.setId(1L);
    }

    @Test
    @DisplayName("Create post - success")
    public void createTest01() {
        BDDMockito.doReturn(savedPost01).when(postRepo).save(mockPost01);
        Post post = postService.create(1L, mockPost01);
        Assertions.assertEquals(savedPost01, post);
    }

    @Test
    @DisplayName("Get by id - success")
    public void getByIdTest01() throws Exception {
        BDDMockito.doReturn(Optional.of(savedPost01)).when(postRepo).findById(1L);
        Post post = postService.getById(1L);
        Assertions.assertEquals(savedPost01, post);
    }

    @Test
    @DisplayName("Get by id - failed")
    public void getByIdTest02() {
        BDDMockito.doReturn(Optional.empty()).when(postRepo).findById(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            postService.getById(1L);
        });
    }

    @Test
    @DisplayName("Get all - success")
    public void getAllTest01() {
        List<Post> posts = new ArrayList<>();
        posts.add(savedPost01);
        BDDMockito.doReturn(posts).when(postRepo).findAll();
        List<Post> actual = postService.getAll();
        Assertions.assertIterableEquals(posts, actual);
    }

    @Test
    @DisplayName("Get all from user - success")
    public void getAllFromUserTest01() {
        List<Post> posts = new ArrayList<>();
        posts.add(savedPost01);
        BDDMockito.doReturn(posts).when(postRepo).findByPublisher(null);
        List<Post> actual = postService.getAllFromUser(null);
        Assertions.assertIterableEquals(posts, actual);
    }

    @Test
    @DisplayName("Update - success")
    public void updateTest01() throws Exception {
        Post updated = new Post(null, "This is a post", 50000, new ArrayList<>());
        updated.setId(1L);
        BDDMockito.doReturn(Optional.of(savedPost01)).when(postRepo).findById(1L);
        BDDMockito.doReturn(updated).when(postRepo).save(savedPost01);
        Post actual = postService.update(1L, updated);
        Assertions.assertEquals(updated, actual);
    }

}
