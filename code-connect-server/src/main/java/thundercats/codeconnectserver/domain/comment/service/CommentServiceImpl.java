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
    public Comment create(Comment comment, Long id) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Comment update(Comment comment) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public void delete(Comment comment) throws ResourceNotFoundException {

    }
}
