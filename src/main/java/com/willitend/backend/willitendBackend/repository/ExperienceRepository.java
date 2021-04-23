package com.willitend.backend.willitendBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.willitend.backend.willitendBackend.model.Experience;
import com.willitend.backend.willitendBackend.model.ExperienceId;

public interface ExperienceRepository extends CrudRepository <Experience, ExperienceId> {

	Page<Experience> findAll(Pageable paging);
}
