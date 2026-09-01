package io.github.juanmanuelgiulietti.ums.university.dto;

public record UniversityResponse(
    Long universityId,
    String name,
    String address,
    String phoneNumber,
    String email
) {}