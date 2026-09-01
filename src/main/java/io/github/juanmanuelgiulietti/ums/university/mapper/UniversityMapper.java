package io.github.juanmanuelgiulietti.ums.university.mapper;

import org.springframework.stereotype.Component;

import io.github.juanmanuelgiulietti.ums.university.dto.UniversityRequest;
import io.github.juanmanuelgiulietti.ums.university.dto.UniversityResponse;
import io.github.juanmanuelgiulietti.ums.university.entity.University;

@Component
public class UniversityMapper {

    public University toEntity(UniversityRequest request) {
        University university = new University();
        university.setName(request.name());
        university.setAddress(request.address());
        university.setPhoneNumber(request.phoneNumber());
        university.setEmail(request.email());
        return university;
    }

    public UniversityResponse toResponse(University university) {
        return new UniversityResponse(
            university.getUniversityId(),
            university.getName(),
            university.getAddress(),
            university.getPhoneNumber(),
            university.getEmail()
        );
    }

    public void updateEntity(University university, UniversityRequest request) {
        university.setName(request.name());
        university.setAddress(request.address());
        university.setPhoneNumber(request.phoneNumber());
        university.setEmail(request.email());
    }
}