package com.api.auth.service;

import com.api.auth.data.entities.ExpiredToken;

public interface IExpiredTokenService {

    ExpiredToken blacklistToken(String token);

    Boolean isTokenExpired(String token);
}
