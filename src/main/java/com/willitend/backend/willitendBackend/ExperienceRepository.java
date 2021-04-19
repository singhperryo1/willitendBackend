package com.willitend.backend.willitendBackend;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willitend.backend.willitendBackend.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
	
}