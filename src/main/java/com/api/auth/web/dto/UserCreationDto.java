package com.api.auth.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreationDto {



    @Email(message = "Le champ doit être un email")
    @NotNull(message = "Le champ email est obligatoire")
    private String email;
    @NotNull(message = "Le champ mot de passe est obligatoire")
    @Size(message = "Le champ password doit avoir minimum 8 caractère et maximum 100",min = 8,max = 100)
    private String password;
}