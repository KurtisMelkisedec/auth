package com.api.auth.service.impl;

import com.api.auth.data.entities.AppUser;
import com.api.auth.data.repositories.IAppUserRepository;
import com.api.auth.service.IExpiredTokenService;
import com.api.auth.service.IJwtService;
import com.api.auth.service.ISecurityService;
import com.api.auth.service.IUserService;
import com.api.auth.web.dto.LoginRequestDto;
import com.api.auth.web.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;
    private final IExpiredTokenService expiredTokenService;
    private final IAppUserRepository userRepository;
    @Override
    public TokenResponseDto login(LoginRequestDto user) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getLogin(),user.getPassword())
        );
        if (authentication.isAuthenticated()){
            String token=jwtService.createToken(user.getLogin());
            if (!expiredTokenService.isTokenExpired(token)){
                AppUser user1=userRepository.findByLogin(user.getLogin());
                return TokenResponseDto.builder()
                        .id(user1.getId())
                        .login(user.getLogin())
                        .token(token)
                        .roles(authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                        .username(user1.getLogin())
                        .build();
            }

        }
        return null;

    }
    @Override
    public void updateAccount(AppUser user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
    }
}
