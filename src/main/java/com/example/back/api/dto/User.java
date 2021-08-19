package com.example.back.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Base64;

@Setter
@Getter
@RequiredArgsConstructor
public class User {
    private final String id;
    private final String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
