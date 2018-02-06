package com.lidsys.application.graphs.service.business;

import com.lidsys.application.graphs.entity.bo.GraphConfig;

public interface GraphConfigService
	{
		
		GraphConfig findByProgramIdAndGraph(String programId, String key);
		
		void save(GraphConfig graphConfig);
		
	}
