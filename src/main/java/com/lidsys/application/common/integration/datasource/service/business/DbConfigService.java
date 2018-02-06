package com.lidsys.application.common.integration.datasource.service.business;

import com.lidsys.application.common.integration.datasource.entity.bo.DbConfig;

public interface DbConfigService
	{
		public void save(DbConfig config);
		
		public DbConfig findByProgramId(String programId);
	}
