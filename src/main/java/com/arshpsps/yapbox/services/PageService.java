package com.arshpsps.yapbox.services;

import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.models.Page;
import com.arshpsps.yapbox.repository.PageRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PageService {
    private PageRepository pageRepository;

    public Page getPage(Long id) {
        return this.pageRepository.findById(id).orElseThrow(() -> new RuntimeException("Page doesn't exist!"));
    }
}
