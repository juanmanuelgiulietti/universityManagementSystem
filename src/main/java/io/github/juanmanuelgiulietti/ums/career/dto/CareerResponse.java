package io.github.juanmanuelgiulietti.ums.career.dto;

import io.github.juanmanuelgiulietti.ums.university.dto.UniversitySummaryResponse;

public record CareerResponse(
        Long careerId,
        String name,
        UniversitySummaryResponse university,
        Integer duration,
        String degreeAwarded) {
}
