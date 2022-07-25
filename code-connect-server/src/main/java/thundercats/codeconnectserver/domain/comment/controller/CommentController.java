package thundercats.codeconnectserver.domain.comment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thundercats.codeconnectserver.domain.comment.model.Comment;
import thundercats.codeconnectserver.domain.comment.service.CommentService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAll();
    }
    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentService.create(comment);
    }
    @GetMapping("{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable long id){
        Comment comment = commentService.getById(id);
        return ResponseEntity.ok(comment);
    }
    @PutMapping("{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable long id, @RequestBody Comment newComment){
        Comment updateComment = commentService.update(newComment, id);
        return ResponseEntity.ok(updateComment);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable long id){
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
