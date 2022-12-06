package com.project.GORZDRAV.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR,
    DOCTOR;
    @Override
    public String getAuthority() {
        return name();
    }
}