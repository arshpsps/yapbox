package com.arshpsps.yapbox.security;

import java.util.Map;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityEndpoints {
//    @GetMapping("/csrf-token")
//    public Map<String, String> getCsrfToken(HttpServletRequest request, CsrfToken csrfToken) {
//        return Map.of(
//                "token", csrfToken.getToken());
//    }
}
