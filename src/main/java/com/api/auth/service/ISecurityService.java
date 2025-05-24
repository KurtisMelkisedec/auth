package com.api.auth.service;

import com.api.auth.data.entities.AppRole;
import com.api.auth.data.entities.AppUser;
import com.api.auth.web.dto.LoginRequestDto;
import com.api.auth.web.dto.TokenResponseDto;
import com.api.auth.web.dto.UserCreationDto;

public interface ISecurityService {
    AppUser findUserByLogin(String login);
    AppRole findRoleByRoleName(String roleName);




    AppUser saveUser(UserCreationDto user);

    AppRole saveRole(String roleName);

    void addRoleToUser(String roleName,String login);
}
