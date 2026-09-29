package io.github.juanmanuelgiulietti.ums.career.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.juanmanuelgiulietti.ums.career.entity.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {

    boolean existsByNameAndUniversityUniversityId(String name, Long universityId);

    boolean existsByNameAndUniversityUniversityIdAndCareerIdNot(String name, Long universityId, Long careerId);

    @Query("SELECT c FROM Career c JOIN FETCH c.university")
    List<Career> findAllWithUniversity();
}
