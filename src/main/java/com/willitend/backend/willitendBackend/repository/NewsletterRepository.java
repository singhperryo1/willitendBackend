package com.willitend.backend.willitendBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.willitend.backend.willitendBackend.model.Newsletter;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
	@Query("SELECT n FROM Newsletter n WHERE n.email = ?1")
	Newsletter findByEmail(String email); 
}
