package com.bookcorner.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_USER, ROLE_PREMIUM;


    @Override
    public String getAuthority() {
        return name();
    }
}
