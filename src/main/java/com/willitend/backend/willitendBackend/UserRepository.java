package com.willitend.backend.willitendBackend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
	List<User> findByState(String state);
	List<User> findByUsername(String username);
	Iterable<User> findByTitleContaining(String email);

	
	

}
