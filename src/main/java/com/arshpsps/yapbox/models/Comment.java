package com.arshpsps.yapbox.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Table(name = "comments")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;

    @Column(nullable = false)
    ZonedDateTime creationDate;

    @ManyToOne
    private AuthUser author;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    @JsonIgnore
    private Page page;
}
