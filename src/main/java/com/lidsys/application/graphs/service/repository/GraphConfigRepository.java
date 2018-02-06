package com.lidsys.application.graphs.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lidsys.application.graphs.entity.bo.GraphConfig;

@Repository
public interface GraphConfigRepository extends CrudRepository<GraphConfig, Long>
	{
		GraphConfig findByProgramIdAndGraph(String programId, String graph);
	}
