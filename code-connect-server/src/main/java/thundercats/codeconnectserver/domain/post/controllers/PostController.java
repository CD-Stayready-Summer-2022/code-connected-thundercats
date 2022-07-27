package thundercats.codeconnectserver.domain.post.controllers;

import com.google.firebase.remoteconfig.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thundercats.codeconnectserver.domain.post.models.Post;
import thundercats.codeconnectserver.domain.post.services.PostService;
import thundercats.codeconnectserver.domain.userprofile.models.UserProfile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("{id}")
    public ResponseEntity<Post> create(@PathVariable("id") Long user_id, @RequestBody Post post) {
        post = postService.create(user_id, post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getById(@PathVariable("id") Long postId) {
        Post post = postService.getById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Post>> getAllFromUser(@PathVariable("id") Long user_id) {
        List<Post> posts = postService.getAllFromUser(user_id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        List<Post> posts = postService.getAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> update(@PathVariable("id") Long id, @RequestBody Post postDetails) {
        Post newPost = postService.update(id, postDetails);
        return new ResponseEntity<>(newPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
