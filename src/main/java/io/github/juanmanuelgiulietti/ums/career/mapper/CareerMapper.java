package io.github.juanmanuelgiulietti.ums.career.mapper;

import org.springframework.stereotype.Component;

import io.github.juanmanuelgiulietti.ums.career.dto.CareerRequest;
import io.github.juanmanuelgiulietti.ums.career.dto.CareerResponse;
import io.github.juanmanuelgiulietti.ums.career.dto.CareerSummaryResponse;
import io.github.juanmanuelgiulietti.ums.career.entity.Career;
import io.github.juanmanuelgiulietti.ums.university.entity.University;
import io.github.juanmanuelgiulietti.ums.university.mapper.UniversityMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CareerMapper {

    private final UniversityMapper universityMapper;

    public Career toEntity(CareerRequest request, University university) {
        Career career = new Career();
        career.setName(request.name());
        career.setUniversity(university);
        career.setDuration(request.duration());
        career.setDegreeAwarded(request.degreeAwarded());
        return career;
    }

    public CareerResponse toResponse(Career career) {
        return new CareerResponse(
                career.getCareerId(),
                career.getName(),
                universityMapper.toSummary(career.getUniversity()),
                career.getDuration(),
                career.getDegreeAwarded());
    }

    public CareerSummaryResponse toSummary(Career career) {
        return new CareerSummaryResponse(
                career.getCareerId(),
                career.getName(),
                universityMapper.toSummary(career.getUniversity()));
    }

    public void updateEntity(Career career, CareerRequest request) {
        career.setName(request.name());
        career.setDuration(request.duration());
        career.setDegreeAwarded(request.degreeAwarded());
    }
}
