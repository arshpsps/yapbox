package com.arshpsps.yapbox.controllers;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.services.PageService;

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
    public Long createPage() {
        return pageService.createPage();
    }
}
