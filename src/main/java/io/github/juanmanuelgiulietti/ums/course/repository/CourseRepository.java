package io.github.juanmanuelgiulietti.ums.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import io.github.juanmanuelgiulietti.ums.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByNameAndCareerCareerId(String name, Long careerId);

    boolean existsByNameAndCareerCareerIdAndCourseIdNot(String name, Long careerId, Long courseId);

    @Query("SELECT c FROM Course c JOIN FETCH c.career car JOIN FETCH car.university")
    List<Course> findAllWithCareerAndUniversity();
}
