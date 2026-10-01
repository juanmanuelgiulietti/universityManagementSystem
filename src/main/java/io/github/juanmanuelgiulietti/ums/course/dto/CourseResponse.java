package io.github.juanmanuelgiulietti.ums.course.dto;

import io.github.juanmanuelgiulietti.ums.career.dto.CareerSummaryResponse;

public record CourseResponse(
        Long courseId,
        String name,
        CareerSummaryResponse career) {
}
