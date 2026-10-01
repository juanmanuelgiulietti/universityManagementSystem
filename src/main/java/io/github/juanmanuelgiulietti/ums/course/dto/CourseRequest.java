package io.github.juanmanuelgiulietti.ums.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequest(
        @NotBlank(message = "Name is required") @Size(max = 255, message = "Name must be less than or equal to 255 characters") String name,

        @NotNull(message = "Career ID is required") Long careerId) {
}
