package com.willitend.backend.willitendBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.willitend.backend.willitendBackend.model.Stateinfo;

public interface StateinfoRepository extends JpaRepository<Stateinfo, Long> {
	
	@Query("SELECT s FROM Stateinfo s WHERE s.name = ?1")
	Stateinfo findByName(String name); 
}
