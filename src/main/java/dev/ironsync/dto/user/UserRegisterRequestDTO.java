package dev.ironsync.dto.user;

import dev.ironsync.model.Gender;
import dev.ironsync.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRegisterRequestDTO (
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    String username,

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be at least 8 characters long")
    String password,

    @NotBlank(message = "Birth date is required")
    @Past(message = "Birth date must be a date in the past")
    LocalDate birthDate,

    @NotNull(message = "Gender is required")
    Gender gender,

    Role role
) {}
