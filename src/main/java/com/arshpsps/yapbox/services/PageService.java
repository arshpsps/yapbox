package com.arshpsps.yapbox.services;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import com.arshpsps.yapbox.models.Page;
import com.arshpsps.yapbox.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PageService {
    private final PageRepository pageRepository;

    public Page getPage(Long id) {
        return this.pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Page doesn't exist!"));
    }

    public List<Comment> getComments(Long id){
        return this.pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Page doesn't exist!")).getComment();
    }

    public Long createPage() {
        Long id = this.pageRepository.save(new Page()).getId();
        System.out.println(id);
        System.out.println("IG CREATED????");
        return id;
    }
}
