package io.github.juanmanuelgiulietti.ums.university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "university")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityId;

    @Column(nullable = false)
    private String name;

    private String address;

    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;
}
