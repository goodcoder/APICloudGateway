package com.gabbar.apicloudgateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String userId;
    private Collection<String> authorities;
    private Map<String, Object> claims;
}