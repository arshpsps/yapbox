package com.arshpsps.yapbox.services;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.repository.CommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final AuthUserService authUserService;
    private final PageService pageService;

    public void save(CommentDto comment, String authorId, Long pageId) {
        Comment c = new Comment();
        c.setPage(pageService.getPage(pageId));
        c.setAuthor(authUserService.getUser(authorId));
        c.setCreationDate(ZonedDateTime.now(ZoneId.of("UTC")));
        c.setMessage(comment.getMessage());

        this.commentRepository.save(c);
    }

    public Comment update(Long id, CommentDto comment) {
        Comment foundComment = get(id);
        foundComment.setMessage(comment.getMessage());
        return commentRepository.save(foundComment);
    }

    public Comment get(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found!"));
    }
}
