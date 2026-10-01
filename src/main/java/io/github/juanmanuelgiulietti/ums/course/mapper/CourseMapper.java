package io.github.juanmanuelgiulietti.ums.course.mapper;

import org.springframework.stereotype.Component;

import io.github.juanmanuelgiulietti.ums.career.entity.Career;
import io.github.juanmanuelgiulietti.ums.career.mapper.CareerMapper;
import io.github.juanmanuelgiulietti.ums.course.dto.CourseRequest;
import io.github.juanmanuelgiulietti.ums.course.dto.CourseResponse;
import io.github.juanmanuelgiulietti.ums.course.entity.Course;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final CareerMapper careerMapper;

    public Course toEntity(CourseRequest request, Career career) {
        Course course = new Course();
        course.setName(request.name());
        course.setCareer(career);
        return course;
    }

    public CourseResponse toResponse(Course course) {
        return new CourseResponse(
                course.getCourseId(),
                course.getName(),
                careerMapper.toSummary(course.getCareer()));
    }

    public void updateEntity(Course course, CourseRequest request) {
        course.setName(request.name());
    }
}
