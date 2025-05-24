package com.api.auth.service.impl;

import com.api.auth.data.entities.AppRole;
import com.api.auth.data.entities.AppUser;
import com.api.auth.data.repositories.IAppRoleRepository;
import com.api.auth.data.repositories.IAppUserRepository;
import com.api.auth.exceptions.EntityAlreadyExists;
import com.api.auth.exceptions.EntityNotFound;
import com.api.auth.service.IExpiredTokenService;
import com.api.auth.service.IJwtService;
import com.api.auth.service.ISecurityService;
import com.api.auth.web.dto.LoginRequestDto;
import com.api.auth.web.dto.TokenResponseDto;
import com.api.auth.web.dto.UserCreationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements ISecurityService, UserDetailsService
{


    private final IAppUserRepository userRepository;
    private final IAppRoleRepository roleReposiroty;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AppUser findUserByLogin(String email) {
        return userRepository.findByLogin(email);
    }

    @Override
    public AppRole findRoleByRoleName(String roleName) {
        return roleReposiroty.findByRoleName(roleName);
    }



    @Override
    public AppUser saveUser(UserCreationDto newUser) {
        AppUser user = userRepository.findByLogin(newUser.getEmail());
        if (user != null) throw new EntityAlreadyExists("Un utilisateur avec cet email existe déjà", HttpStatus.CONFLICT);
        user = new AppUser();
        user.setLogin(newUser.getEmail());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));


        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(String roleName) {
        AppRole role= roleReposiroty.findByRoleName(roleName);
        if (role != null) throw new EntityAlreadyExists(String.format("Un role avec le nom %s existe déjà.",roleName), HttpStatus.CONFLICT);
        role = new AppRole();
        role.setRoleName(roleName);
        roleReposiroty.save(role);
        return role;
    }

    @Override
    public void addRoleToUser(String roleName, String login) {
        AppUser user = findUserByLogin(login);
        if(user == null) throw new EntityNotFound(String.format("Aucun utilisateur avec l'email %s", login), HttpStatus.NOT_FOUND);
        AppRole role = roleReposiroty.findByRoleName(roleName);
        if (role == null) throw new EntityNotFound(String.format("Aucun role avec le nom %s", login), HttpStatus.NOT_FOUND);
        user.getRoles().add(role);
        userRepository.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        AppUser user = userRepository.findByLogin(login);
        if (user==null)throw new EntityNotFound(String.format("Aucun utilisateur avec l'email %s",login),HttpStatus.NOT_FOUND);
        List<SimpleGrantedAuthority> authorities=user.getRoles().stream().map(r->new SimpleGrantedAuthority(r.getRoleName())).toList();
        return new User(user.getLogin(),user.getPassword(),authorities);
    }
}