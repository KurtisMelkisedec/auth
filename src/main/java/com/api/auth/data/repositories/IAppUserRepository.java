package com.api.auth.data.repositories;

import com.api.auth.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByLogin(String email);

}
