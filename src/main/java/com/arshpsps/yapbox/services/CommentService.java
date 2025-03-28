package com.arshpsps.yapbox.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.repository.CommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getCommentsFromPage(Long id) {
        return commentRepository.findAllByPageId(id);
    }

}
