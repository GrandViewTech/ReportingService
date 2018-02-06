package com.lidsys.application.common.integration.datasource.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidsys.application.common.integration.datasource.entity.bo.DbConfig;
import com.lidsys.application.common.integration.datasource.service.business.DbConfigService;
import com.lidsys.application.common.integration.datasource.service.repository.DbConfigRepository;

@Service
public class DbConfigServiceImpl implements DbConfigService
	{
		@Autowired
		private DbConfigRepository dbConfigRepository;
		
		@Override
		public void save(DbConfig config)
			{
				DbConfig existing = findByProgramId(config.getProgramId());
				if (existing != null)
					{
						existing = existing.update(config);
						dbConfigRepository.save(existing);
					}
				else
					{
						dbConfigRepository.save(config);
					}
			}
			
		@Override
		public DbConfig findByProgramId(String programId)
			{
				return dbConfigRepository.findByProgramId(programId);
			}
			
	}
