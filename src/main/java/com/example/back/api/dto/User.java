package com.example.back.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@RequiredArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

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
