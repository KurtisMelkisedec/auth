package com.api.auth.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginRequestDto {
    @Email()
    @NotNull()
    private String login;
    @NotNull()
    @Size(min = 8,max = 100)
    private String password;
}
