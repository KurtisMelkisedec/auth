package com.api.auth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class EntityAlreadyExists extends RuntimeException{

    private HttpStatus status;

    public EntityAlreadyExists(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
