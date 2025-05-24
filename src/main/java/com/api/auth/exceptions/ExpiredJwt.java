package com.api.auth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ExpiredJwt extends RuntimeException {
    private HttpStatus status;
    public ExpiredJwt(String message,HttpStatus status) {
        super(message);
        this.status=status;
    }
    }
