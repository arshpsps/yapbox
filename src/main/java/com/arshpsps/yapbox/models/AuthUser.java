package com.arshpsps.yapbox.models;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authusers")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthUser {
    @Id
    @JsonValue
    @Column(nullable = false, unique = true)
    private String googleId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    private String pictureUrl;
    private String givenName;
    private String familyName;
}
