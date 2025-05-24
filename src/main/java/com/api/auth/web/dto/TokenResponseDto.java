package com.api.auth.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class TokenResponseDto {
    private Long id;
    private String username;
    private String login;
    private List<String> roles=new ArrayList<>();
    private String token;
}

