package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
