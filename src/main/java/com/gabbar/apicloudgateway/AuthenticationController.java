package com.gabbar.apicloudgateway;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AuthenticationController {

/*    @GetMapping("/login")
    public ResponseEntity<?> login(
            @AuthenticationPrincipal(errorOnInvalidType = false) OidcUser oidcUser,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client
    ) {
        if (oidcUser != null) {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("username", oidcUser.getFullName());
            userInfo.put("idToken", oidcUser.getIdToken().getTokenValue());
            userInfo.put("accessToken", client.getAccessToken().getTokenValue());

            return ResponseEntity.ok(userInfo);
        } else {
            return ResponseEntity.ok("User not authenticated");
        }
    }*/

        @GetMapping("/signin")
    public ResponseEntity<?> signin(
            @AuthenticationPrincipal OidcUser oidcUser

    ) {
        if (oidcUser != null) {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("username", oidcUser.getFullName());
            userInfo.put("idToken", oidcUser.getIdToken().getTokenValue());

            return ResponseEntity.ok(userInfo);
        } else {
            return ResponseEntity.ok("User not authenticated");
        }
    }


    @GetMapping("/test")
    public String test() {
        return "Test endpoint working fine";
    }
}