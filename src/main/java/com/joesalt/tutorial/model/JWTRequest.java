package com.joesalt.tutorial.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JWTRequest {

    private String email;
    private String password;
}
