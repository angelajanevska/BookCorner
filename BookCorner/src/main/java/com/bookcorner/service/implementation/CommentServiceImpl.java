//package com.bookcorner.service.implementation;
//
//import com.bookcorner.model.Comment;
//import com.bookcorner.model.exceptions.UserNotFoundException;
//import com.bookcorner.repository.CommentRepository;
//import com.bookcorner.repository.UserRepository;
//import com.bookcorner.service.CommentService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CommentServiceImpl implements CommentService {
//
//    private final CommentRepository commentRepository;
//    private final UserRepository userRepository;
//
//    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
//        this.commentRepository = commentRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void save(String text, Long userId) {
//        this.commentRepository.save(new Comment(userRepository.getById(userId), text));
//    }
//
//    @Override
//    public Optional<Comment> findByUsername(String username) {
//        return this.commentRepository.findByUsername(userRepository.findByUsername(username)
//        .orElseThrow(() -> new UserNotFoundException(username)));
//    }
//
//    @Override
//    public List<Comment> findAll() {
//        return this.commentRepository.findAll();
//    }
//}
