package io.github.juanmanuelgiulietti.ums.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.juanmanuelgiulietti.ums.university.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndUniversityIdNot(String email, Long universityId);
}
