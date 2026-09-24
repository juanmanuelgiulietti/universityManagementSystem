package io.github.juanmanuelgiulietti.ums.career.entity;

import io.github.juanmanuelgiulietti.ums.university.entity.University;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "career")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careerId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    private Integer duration;

    private String degreeAwarded;
}
