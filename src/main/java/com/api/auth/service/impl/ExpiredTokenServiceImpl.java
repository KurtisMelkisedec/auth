package com.api.auth.service.impl;

import com.api.auth.data.entities.ExpiredToken;
import com.api.auth.data.repositories.IExpiredTokenRepository;
import com.api.auth.service.IExpiredTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpiredTokenServiceImpl implements IExpiredTokenService {
    private final IExpiredTokenRepository expiredTokenRepository;

    @Override
    public ExpiredToken blacklistToken(String token) {
        ExpiredToken expiredToken = new ExpiredToken();
        expiredToken.setToken(token);
        return expiredTokenRepository.save(expiredToken);
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return expiredTokenRepository.findByToken(token) != null;
    }
}