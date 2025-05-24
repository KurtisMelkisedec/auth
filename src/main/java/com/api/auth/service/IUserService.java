package com.api.auth.service;

import com.api.auth.data.entities.AppUser;
import com.api.auth.web.dto.LoginRequestDto;
import com.api.auth.web.dto.TokenResponseDto;

public interface IUserService {
    TokenResponseDto login(LoginRequestDto user);

    void updateAccount(AppUser user);
}
