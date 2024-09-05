package com.webapp.student;

import java.util.Set;

import lombok.Data;
@Data
public class TeacherDTO {
	 private Long id;
	    private String name;
	    private Set<SubjectDTO> subjects;
    // Getters and Setters
}
