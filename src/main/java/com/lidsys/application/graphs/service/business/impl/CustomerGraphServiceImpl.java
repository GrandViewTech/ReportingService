package com.lidsys.application.graphs.service.business.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidsys.application.graphs.entity.bo.GraphConfig;
import com.lidsys.application.graphs.service.business.CustomerGraphService;
import com.lidsys.application.graphs.service.business.GraphConfigService;
import com.lidsys.application.search.entity.dto.QueryRequest;
import com.lidsys.application.search.entity.dto.SearchRequest;
import com.lidsys.application.search.service.business.CustomerSearchService;
import com.lidsys.application.search.service.business.SearchService;
import com.lidsys.application.search.service.plugin.SearchPlugin;

@Service
public class CustomerGraphServiceImpl implements CustomerGraphService
	{
		@Autowired
		private CustomerSearchService	customerSearchService;
		
		@Autowired
		private GraphConfigService		graphConfigService;
		
		@Override
		public Map<String, BigDecimal> enrollmentByAge(String programId, SearchRequest searchRequest)
			{
				String graph = "enrollmentByAge";
				GraphConfig graphConfig = graphConfigService.findByProgramIdAndGraph(programId, graph);
				String baseQuery = graphConfig.getBaseQuery();
				return customerSearchService.enrollmentByAge(programId, baseQuery, searchRequest);
			}
	}
