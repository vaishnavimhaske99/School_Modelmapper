package com.webapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Data
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One Teacher can teach many Subjects
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private Set<Subject> subjects;
}
