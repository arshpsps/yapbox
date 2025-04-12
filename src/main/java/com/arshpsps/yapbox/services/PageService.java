package com.arshpsps.yapbox.services;

import com.arshpsps.yapbox.dto.CommentDto;
import com.arshpsps.yapbox.models.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.models.Page;
import com.arshpsps.yapbox.repository.PageRepository;

import lombok.AllArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PageService {
    private final PageRepository pageRepository;
    private final AuthUserService authUserService;

    public Page getPage(Long id) {
        return this.pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Page doesn't exist!"));
    }

    public List<Comment> getComments(Long id){
        return this.pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Page doesn't exist!")).getComment();
    }

    public void saveComment(CommentDto comment, String authorId, Long pageId) {
        Comment c = new Comment();
        c.setAuthor(authUserService.getUser(authorId));
        c.setCreationDate(ZonedDateTime.now(ZoneId.of("UTC")));
        c.setMessage(comment.getMessage());
        Page page = getPage(pageId);
        page.getComment().add(c);
        pageRepository.save(page);
    }

    public Long createPage() {
        Long id = this.pageRepository.save(new Page()).getId();
        System.out.println(id);
        System.out.println("IG CREATED????");
        return id;
    }
}
