package com.bookcorner.repository;

import com.bookcorner.model.Comment;
import com.bookcorner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByUsername(User username);
    List<Comment> findAll();
}
