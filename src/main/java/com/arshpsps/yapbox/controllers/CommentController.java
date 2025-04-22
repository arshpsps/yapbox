package com.arshpsps.yapbox.controllers;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("pages")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("{id}/savecomment")
    public ResponseEntity<?> saveComment(@PathVariable("id") Long id, @RequestBody CommentDto comment, OAuth2AuthenticationToken oauthToken) {
        commentService.save(comment, oauthToken.getPrincipal().getAttribute("sub"), id);
        return ResponseEntity.ok().build();
    }
}
