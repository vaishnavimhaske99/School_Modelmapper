package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
