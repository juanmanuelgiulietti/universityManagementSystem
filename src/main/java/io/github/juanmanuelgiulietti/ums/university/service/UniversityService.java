package io.github.juanmanuelgiulietti.ums.university.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.juanmanuelgiulietti.ums.exception.DuplicateResourceException;
import io.github.juanmanuelgiulietti.ums.exception.ResourceNotFoundException;
import io.github.juanmanuelgiulietti.ums.university.dto.UniversityRequest;
import io.github.juanmanuelgiulietti.ums.university.dto.UniversityResponse;
import io.github.juanmanuelgiulietti.ums.university.mapper.UniversityMapper;
import io.github.juanmanuelgiulietti.ums.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UniversityService {
    private final UniversityRepository repository;
    private final UniversityMapper mapper;

    @Transactional
    public UniversityResponse createUniversity(UniversityRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("University", "email", request.email());
        }
        var university = mapper.toEntity(request);
        var savedUniversity = repository.save(university);
        return mapper.toResponse(savedUniversity);
    }

    @Transactional(readOnly = true)
    public List<UniversityResponse> getAllUniversities() {
        var universities = repository.findAll();
        return universities.stream().map(mapper::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public UniversityResponse getUniversityById(Long id) {
        var university = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", id));
        return mapper.toResponse(university);
    }

    @Transactional
    public UniversityResponse updateUniversity(Long id, UniversityRequest request) {
        var university = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", id));
        if (!university.getEmail().equals(request.email()) && repository.existsByEmailAndUniversityIdNot(request.email(), id)) {
            throw new DuplicateResourceException("University", "email", request.email());
        }
        mapper.updateEntity(university, request);
        return mapper.toResponse(university);
    }

    @Transactional
    public void deleteUniversity(Long id) {
        var university = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("University", id));
        repository.delete(university);
    }
}
