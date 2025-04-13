package com.arshpsps.yapbox.controllers;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.services.CommentService;
import com.arshpsps.yapbox.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("pages")
public class CommentController {
    private final CommentService commentService;
    private final PageService pageService;

    @PostMapping("{id}/savecomment")
    public ResponseEntity<?> saveComment(@PathVariable("id") Long id, @RequestBody CommentDto comment, OAuth2AuthenticationToken oauthToken) {
        System.out.println("----------------FSAFSAF-----------");
        System.out.println((String) oauthToken.getPrincipal().getAttribute("sub"));
        pageService.saveComment(comment, oauthToken.getPrincipal().getAttribute("sub"), id);
        return ResponseEntity.ok().build();
    }
}
