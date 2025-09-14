package com.arshpsps.yapbox.controllers;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.repository.CommentRepository;
import com.arshpsps.yapbox.services.CommentService;
import com.arshpsps.yapbox.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("pages")
public class PageController {
    private final PageService pageService;

    @GetMapping("{id}")
    public List<Comment> page(@PathVariable Long id) {
        return pageService.getComments(id);
    }

    @GetMapping("create")
    @PreAuthorize("isAuthenticated()")
    public Long createPage(OAuth2AuthenticationToken oauthToken) {
        return pageService.createPage(oauthToken.getPrincipal().getAttribute("sub"));
    }
}
