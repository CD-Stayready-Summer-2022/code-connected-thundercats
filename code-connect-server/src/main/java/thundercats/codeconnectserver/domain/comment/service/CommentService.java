package thundercats.codeconnectserver.domain.comment.service;

import thundercats.codeconnectserver.domain.comment.model.Comment;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;

import java.util.List;

public interface CommentService {
    Comment create(Comment comment);
    List<Comment> getAll();
    Comment getById (Long id) throws ResourceNotFoundException;
    Comment update(Comment comment, Long id) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}