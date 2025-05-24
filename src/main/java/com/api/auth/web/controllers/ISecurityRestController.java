package com.api.auth.web.controllers;

import com.api.auth.web.dto.LoginRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/")
public interface ISecurityRestController {

    @PostMapping("guest/token")
    ResponseEntity<?> login(@RequestBody @Validated LoginRequestDto user);
    
    @GetMapping("guest/accounts/{login}")
    ResponseEntity<?> isAccountExists(@PathVariable String login);
    @GetMapping("guest/accounts/{login}/reset-password")
    ResponseEntity<?> resetPassword(@PathVariable String login);

    @PostMapping("guest/accounts/password")
    ResponseEntity<?> changePassword(@RequestBody @Validated LoginRequestDto user);
    

}
