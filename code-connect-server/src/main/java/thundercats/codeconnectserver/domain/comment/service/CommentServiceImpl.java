package thundercats.codeconnectserver.domain.comment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thundercats.codeconnectserver.domain.comment.model.Comment;
import thundercats.codeconnectserver.domain.comment.repo.CommentRepo;
import thundercats.codeconnectserver.domain.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepo commentRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }
    @Override
    public Comment create(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }
    @Override
    public Comment getById(Long id) throws ResourceNotFoundException {
        return commentRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Comment with id: " + id));
    }
    @Override
    public Comment update(Comment comment, Long id) throws ResourceNotFoundException {
        Comment updateComment = commentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No comment with id: " + id));
        updateComment.setContent(comment.getContent());
        updateComment.setPost(comment.getPost());
        return commentRepo.save(updateComment);
    }
    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Comment comment = commentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No comment with id " + id));
                commentRepo.delete(comment);
    }
}
