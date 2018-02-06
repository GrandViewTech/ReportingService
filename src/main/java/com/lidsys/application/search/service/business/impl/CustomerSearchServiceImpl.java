package com.lidsys.application.search.service.business.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidsys.application.graphs.entity.bo.GraphConfig;
import com.lidsys.application.graphs.service.business.GraphConfigService;
import com.lidsys.application.search.entity.dto.QueryRequest;
import com.lidsys.application.search.entity.dto.SearchRequest;
import com.lidsys.application.search.service.business.CustomerSearchService;
import com.lidsys.application.search.service.business.SearchService;
import com.lidsys.application.search.service.plugin.SearchPlugin;

@Service
public class CustomerSearchServiceImpl implements CustomerSearchService
	{
	
		@Autowired
		private SearchService		searchService;
		
		@Override
		public Map<String, BigDecimal> enrollmentByAge(String programId, String baseQuery, SearchRequest searchRequest)
			{
				Map<String, BigDecimal> response = new HashMap<>();
				String graph = "enrollmentByAge";
				Object[] requestData = SearchPlugin.prepareHql("customer", baseQuery, searchRequest);
				QueryRequest queryRequest = new QueryRequest(graph, searchRequest, requestData);
				searchService.search(programId, queryRequest);
				return response;
			}
	}
