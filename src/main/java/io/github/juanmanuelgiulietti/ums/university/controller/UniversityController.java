package io.github.juanmanuelgiulietti.ums.university.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.juanmanuelgiulietti.ums.university.dto.UniversityRequest;
import io.github.juanmanuelgiulietti.ums.university.dto.UniversityResponse;
import io.github.juanmanuelgiulietti.ums.university.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService service;

    @PostMapping
    public ResponseEntity<UniversityResponse> createUniversity(@Valid @RequestBody UniversityRequest request) {
    
        var response = service.createUniversity(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UniversityResponse>> getAllUniversities() {
        
        var response = service.getAllUniversities();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityResponse> getUniversityById( @PathVariable Long id) {
       
        var response = service.getUniversityById(id);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UniversityResponse> updateUniversity( @PathVariable Long id, @Valid @RequestBody UniversityRequest request) {
        var response = service.updateUniversity(id, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity( @PathVariable Long id) {
        service.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}
