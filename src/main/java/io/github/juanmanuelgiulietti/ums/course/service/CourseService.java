package io.github.juanmanuelgiulietti.ums.course.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.juanmanuelgiulietti.ums.career.repository.CareerRepository;
import io.github.juanmanuelgiulietti.ums.course.dto.CourseRequest;
import io.github.juanmanuelgiulietti.ums.course.dto.CourseResponse;
import io.github.juanmanuelgiulietti.ums.course.mapper.CourseMapper;
import io.github.juanmanuelgiulietti.ums.course.repository.CourseRepository;
import io.github.juanmanuelgiulietti.ums.exception.DuplicateResourceException;
import io.github.juanmanuelgiulietti.ums.exception.ResourceNotFoundException;
import io.github.juanmanuelgiulietti.ums.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CareerRepository careerRepository;
    private final CourseMapper mapper;

    @Transactional
    public CourseResponse createCourse(CourseRequest request) {
        var career = careerRepository.findById(request.careerId())
                .orElseThrow(() -> new ResourceNotFoundException("Career", request.careerId()));

        if (courseRepository.existsByNameAndCareerCareerId(request.name(),
                request.careerId())) {
            throw new DuplicateResourceException("Course", "name", request.name());
        }

        var newCourse = mapper.toEntity(request, career);
        var savedCourse = courseRepository.save(newCourse);
        return mapper.toResponse(savedCourse);
    }

    @Transactional(readOnly = true)
    public List<CourseResponse> getAllCourses() {
        var courses = courseRepository.findAllWithCareerAndUniversity();
        return courses.stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public CourseResponse getCourseById(Long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", id));
        return mapper.toResponse(course);
    }

    @Transactional
    public CourseResponse updateCourse(Long id, CourseRequest request) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", id));
        if (!course.getCareer().getCareerId().equals(request.careerId())) {
            throw new BusinessRuleException("A course cannot be moved to another career");
        }
        if (courseRepository.existsByNameAndCareerCareerIdAndCourseIdNot(
                request.name(), request.careerId(), id)) {
            throw new DuplicateResourceException("Course", "name", request.name());
        }
        mapper.updateEntity(course, request);
        return mapper.toResponse(course);
    }

    @Transactional
    public void deleteCourse(Long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", id));
        courseRepository.delete(course);
    }
}
