package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
