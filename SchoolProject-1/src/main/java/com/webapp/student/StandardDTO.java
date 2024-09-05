package com.webapp.student;

import java.util.Set;

import lombok.Data;

@Data
public class StandardDTO {
    private Long id;
    private String name;
    private Set<StudentDTO> students;
    private Set<SubjectDTO> subjects;

    // Getters and Setters
}
