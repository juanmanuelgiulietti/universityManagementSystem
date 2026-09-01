package io.github.juanmanuelgiulietti.ums.university.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UniversityRequest(
    @NotBlank(message = "Name is required")
    String name,

    @Size(max = 255, message = "Address must be less than or equal to 255 characters")
    String address,

    @Size(max = 20, message = "Phone number must be less than or equal to 20 characters")
    String phoneNumber,

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email
) {}