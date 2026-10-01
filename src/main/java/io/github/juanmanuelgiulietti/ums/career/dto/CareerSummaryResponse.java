package io.github.juanmanuelgiulietti.ums.career.dto;

import io.github.juanmanuelgiulietti.ums.university.dto.UniversitySummaryResponse;

public record CareerSummaryResponse(
        Long careerId,
        String name,
        UniversitySummaryResponse university) {
}
