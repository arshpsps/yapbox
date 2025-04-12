package com.arshpsps.yapbox.services;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.arshpsps.yapbox.models.AuthUser;
import com.arshpsps.yapbox.repository.AuthUserRepository;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@Service
public class AuthUserService extends DefaultOAuth2UserService {
    private final AuthUserRepository authUserRepository;

    public AuthUser getUser(String id) {
        return this.authUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User doesn't exist"));
    }

    public AuthUser saveUser(AuthUser authUser) {
        return this.authUserRepository.save(authUser);
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        Map<String, Object> attributes = user.getAttributes();
        attributes.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        String sub = (String) attributes.get("sub"); // Unique Google ID
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String picture = (String) attributes.get("picture");
        String family_name = (String) attributes.get("family_name");
        String given_name = (String) attributes.get("given_name");

        AuthUser authUser = authUserRepository.findById(sub)
                .orElseGet(() -> {
                    AuthUser newUser = new AuthUser();
                    newUser.setGoogleId(sub);
                    return newUser;
                });

        authUser.setEmail(email);
        authUser.setName(name);
        authUser.setPictureUrl(picture);
        authUser.setFamilyName(family_name);
        authUser.setGivenName(given_name);

        authUserRepository.save(authUser);

        return user;
    }
}
