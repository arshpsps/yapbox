package com.arshpsps.yapbox.services;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.AuthUser;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.models.Page;
import com.arshpsps.yapbox.repository.AuthUserRepository;
import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.repository.CommentRepository;

import lombok.AllArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

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
}
