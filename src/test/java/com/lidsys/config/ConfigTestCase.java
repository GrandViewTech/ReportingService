package com.lidsys.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lidsys.TestCase;
import com.lidsys.application.common.integration.datasource.entity.bo.DbConfig;
import com.lidsys.application.common.integration.datasource.service.business.DbConfigService;
import com.lidsys.application.graphs.entity.bo.GraphConfig;
import com.lidsys.application.graphs.service.business.GraphConfigService;

public class ConfigTestCase extends TestCase
	{
		@Autowired
		private DbConfigService configService;
		
		
		@Autowired
		private GraphConfigService graphConfigService;
		
		@Test
		public void saveDbConfig()
			{
				String schemaId = "DATAMART_RETAILER_8110155414463100";
				DbConfig config = new DbConfig(programId, schemaId, host, port, user, password);
				configService.save(config);
			}
			
		@Test
		public void saveGraphConfig()
			{
				GraphConfig graphConfig = new GraphConfig(programId, "enrollmentByAge", "SELECT customer FROM Customer customer");
				graphConfigService.save(graphConfig);
			}
	}
