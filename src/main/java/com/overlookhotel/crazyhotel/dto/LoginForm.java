package com.overlookhotel.crazyhotel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginForm {

    @NotBlank(message = "L'email est obligatoire.")
    @Email(message = "Le format de l'email est invalide.")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire.")
    @Size(min = 12, message = "Le mot de passe doit contenir au moins 12 caractères.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{12,}$",
            message = "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre, " +
                    "un caractère spécial et faire au moins 12 caractères."
    )
    private String password;

    // Constructors

    public LoginForm() {
    }

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

