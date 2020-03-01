package com.manager.repository.hospital;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalGuiaRepository {
	
	@Query(value = "")
	public List<Object[]> dados();
	
}
