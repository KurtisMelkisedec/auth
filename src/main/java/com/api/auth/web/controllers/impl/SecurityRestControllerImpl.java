package com.api.auth.web.controllers.impl;

import com.api.auth.data.entities.AppUser;
import com.api.auth.service.ISecurityService;
import com.api.auth.service.IUserService;
import com.api.auth.web.controllers.ISecurityRestController;
import com.api.auth.web.dto.LoginRequestDto;
import com.api.auth.web.dto.RestResponseDto;
import com.api.auth.web.dto.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SecurityRestControllerImpl implements ISecurityRestController {
    private final IUserService userService;
    private final ISecurityService securityService;

    @Override
    public ResponseEntity<?> login(LoginRequestDto user) {
        TokenResponseDto tokenResponseDto= userService.login(user);
        Map<Object,Object> response= RestResponseDto.response(null, HttpStatus.FORBIDDEN);
        if (tokenResponseDto!=null){
            response = RestResponseDto.response(tokenResponseDto,HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(response,(HttpStatusCode)response.get("status"));
    }

    @Override
    public ResponseEntity<?> isAccountExists(String login) {
        Map<Object,Object> response= RestResponseDto.response(null, HttpStatus.NOT_FOUND);
        if (login!=null){
            
            if (securityService.findUserByLogin(login)!=null) {
                response = RestResponseDto.response(true,HttpStatus.OK);
            }
            
        }
       
       return new ResponseEntity<>(response,(HttpStatusCode)response.get("status"));
    }

    @Override
    public ResponseEntity<?> resetPassword(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetPassword'");
    }

    @Override
    public ResponseEntity<?> changePassword(LoginRequestDto user) {
         Map<Object,Object> response= RestResponseDto.response(null, HttpStatus.NOT_FOUND);
        AppUser userDb= securityService.findUserByLogin(user.getLogin());
        if (userDb!=null){
            userDb.setPassword(user.getPassword());
            userService.updateAccount(userDb);
            response = RestResponseDto.response(null,HttpStatus.OK);
            
        }
       
       return new ResponseEntity<>(response,(HttpStatusCode)response.get("status"));
       
    }
}