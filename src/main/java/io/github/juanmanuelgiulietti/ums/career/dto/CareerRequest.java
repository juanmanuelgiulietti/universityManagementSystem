package io.github.juanmanuelgiulietti.ums.career.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CareerRequest(
        @NotBlank(message = "Name is required") @Size(max = 255, message = "Name must be less than or equal to 255 characters") String name,

        @NotNull(message = "University ID is required") Long universityId,

        @Min(value = 1, message = "Duration must be greater or equal to 1") Integer duration,

        @Size(max = 255, message = "Degree Awarded must be less than or equal to 255 characters") String degreeAwarded) {
}
