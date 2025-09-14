package com.arshpsps.yapbox.dto;

import java.util.List;

import com.arshpsps.yapbox.models.AuthUser;
import com.arshpsps.yapbox.models.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDto {
    private AuthUser owner;
    List<Comment> comments;
}
