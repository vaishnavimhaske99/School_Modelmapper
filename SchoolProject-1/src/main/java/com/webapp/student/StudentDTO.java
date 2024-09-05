package com.webapp.student;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	 private Long id;
	    private String name;
	    private String email;
	    private StandardDTO standard;
	    private Set<SubjectDTO> subjects;

    // Getters and Setters
}
