package com.arshpsps.yapbox.dto;

import com.arshpsps.yapbox.models.AuthUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    private String message;
}
