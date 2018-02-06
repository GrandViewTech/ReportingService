package com.lidsys.application.common.integration.datasource.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lidsys.application.common.integration.datasource.entity.bo.DbConfig;
@Repository
public interface DbConfigRepository extends CrudRepository<DbConfig, Long>
	{
		DbConfig findByProgramId(String programid);
	}
