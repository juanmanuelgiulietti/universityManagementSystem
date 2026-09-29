package io.github.juanmanuelgiulietti.ums.career.controller;

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

import io.github.juanmanuelgiulietti.ums.career.dto.CareerRequest;
import io.github.juanmanuelgiulietti.ums.career.service.CareerService;
import io.github.juanmanuelgiulietti.ums.career.dto.CareerRequest;
import io.github.juanmanuelgiulietti.ums.career.dto.CareerResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/careers")
@RequiredArgsConstructor
public class CareerController {
    private final CareerService service;

    @PostMapping
    public ResponseEntity<CareerResponse> createCareer(@Valid @RequestBody CareerRequest request) {

        var response = service.createCareer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CareerResponse>> getAllCareers() {

        var response = service.getAllCareers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareerResponse> getCareerById(@PathVariable Long id) {

        var response = service.getCareerById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareerResponse> updateCareer(@PathVariable Long id,
            @Valid @RequestBody CareerRequest request) {
        var response = service.updateCareer(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCareer(@PathVariable Long id) {
        service.deleteCareer(id);
        return ResponseEntity.noContent().build();
    }
}
