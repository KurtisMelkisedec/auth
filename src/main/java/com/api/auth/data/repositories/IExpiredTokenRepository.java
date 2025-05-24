package com.api.auth.data.repositories;


import com.api.auth.data.entities.ExpiredToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpiredTokenRepository extends JpaRepository<ExpiredToken,Long> {

    ExpiredToken findByToken(String token);
}