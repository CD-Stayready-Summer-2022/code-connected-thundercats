package thundercats.codeconnectserver.domain.comment.service;

import thundercats.codeconnectserver.domain.comment.model.Comment;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment, Long id);
    List<Comment> getAll();


}
