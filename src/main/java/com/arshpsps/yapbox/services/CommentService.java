package com.arshpsps.yapbox.services;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.repository.AuthUserRepository;
import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.repository.CommentRepository;

import lombok.AllArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final AuthUserRepository authUserRepository;
    private final PageService pageService;

    public void save(CommentDto comment, String authorId, Long pageId) {
        Comment c = new Comment();
        c.setAuthor(authUserRepository.findById(authorId).orElseThrow(() -> new RuntimeException("User not found")));
        c.setCreationDate(ZonedDateTime.now(ZoneId.of("UTC")));
        c.setMessage(comment.getMessage());
        c.setPage(pageService.getPage(pageId));
        this.commentRepository.save(c);
    }
}
