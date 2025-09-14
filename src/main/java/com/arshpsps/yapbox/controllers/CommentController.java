package com.arshpsps.yapbox.controllers;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("pages")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> saveComment(@PathVariable("id") Long id, @RequestBody CommentDto comment,
            OAuth2AuthenticationToken oauthToken) {
        commentService.save(comment, oauthToken.getPrincipal().getAttribute("sub"), id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/comment/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> updateComment(@PathVariable("id") Long id, @RequestBody CommentDto comment,
            OAuth2AuthenticationToken oauthToken) {

        if (commentService.get(id).getAuthor().getGoogleId().equals(oauthToken.getPrincipal().getAttribute("sub"))) {
            commentService.update(id, comment);
            System.out.println("GOOOOODYES");
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
