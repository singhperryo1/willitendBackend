package com.willitend.backend.willitendBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willitend.backend.willitendBackend.model.Newsletter; 

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {

}
