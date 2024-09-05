package com.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.model.Standard;

public interface StandardRepository extends JpaRepository<Standard, Long> {
}
