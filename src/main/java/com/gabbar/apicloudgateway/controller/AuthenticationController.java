package com.gabbar.apicloudgateway.controller;

import com.gabbar.apicloudgateway.model.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @GetMapping("/login")
    public ResponseEntity<?> login(
            @AuthenticationPrincipal(errorOnInvalidType = false) OidcUser oidcUser,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client
    ) {
        if (oidcUser != null && client != null) {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("username", oidcUser.getFullName());
            userInfo.put("idToken", oidcUser.getIdToken().getTokenValue());
            userInfo.put("accessToken", client.getAccessToken().getTokenValue());

            // Only add refresh token if it's available
            if (client.getRefreshToken() != null) {
                userInfo.put("refreshToken", client.getRefreshToken().getTokenValue());
            }

            return ResponseEntity.ok(userInfo);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
        }
    }
}
