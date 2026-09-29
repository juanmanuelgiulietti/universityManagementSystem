package io.github.juanmanuelgiulietti.ums.career.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.juanmanuelgiulietti.ums.career.dto.CareerRequest;
import io.github.juanmanuelgiulietti.ums.career.dto.CareerResponse;
import io.github.juanmanuelgiulietti.ums.career.mapper.CareerMapper;
import io.github.juanmanuelgiulietti.ums.career.repository.CareerRepository;
import io.github.juanmanuelgiulietti.ums.exception.DuplicateResourceException;
import io.github.juanmanuelgiulietti.ums.exception.ResourceNotFoundException;
import io.github.juanmanuelgiulietti.ums.exception.BusinessRuleException;
import io.github.juanmanuelgiulietti.ums.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CareerService {
    private final UniversityRepository universityRepository;
    private final CareerRepository careerRepository;
    private final CareerMapper mapper;

    @Transactional
    public CareerResponse createCareer(CareerRequest request) {
        var university = universityRepository.findById(request.universityId())
                .orElseThrow(() -> new ResourceNotFoundException("University", request.universityId()));

        if (careerRepository.existsByNameAndUniversityUniversityId(request.name(),
                request.universityId())) {
            throw new DuplicateResourceException("Career", "name", request.name());
        }

        var career = mapper.toEntity(request, university);
        var savedCareer = careerRepository.save(career);
        return mapper.toResponse(savedCareer);
    }

    @Transactional(readOnly = true)
    public List<CareerResponse> getAllCareers() {
        var careers = careerRepository.findAllWithUniversity();
        return careers.stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public CareerResponse getCareerById(Long id) {
        var career = careerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career", id));
        return mapper.toResponse(career);
    }

    @Transactional
    public CareerResponse updateCareer(Long id, CareerRequest request) {
        var career = careerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career", id));
        if (!career.getUniversity().getUniversityId().equals(request.universityId())) {
            throw new BusinessRuleException("A career cannot be moved to another university");
        }
        if (careerRepository.existsByNameAndUniversityUniversityIdAndCareerIdNot(
                request.name(), request.universityId(), id)) {
            throw new DuplicateResourceException("Career", "name", request.name());
        }
        mapper.updateEntity(career, request);
        return mapper.toResponse(career);
    }

    @Transactional
    public void deleteCareer(Long id) {
        var career = careerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Career", id));
        careerRepository.delete(career);
    }
}
