package com.arshpsps.yapbox.repository;

import com.arshpsps.yapbox.models.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> findAllByPageId(Long id);
}
