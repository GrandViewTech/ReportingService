package com.lidsys.application.search.service.business;

import java.math.BigDecimal;
import java.util.Map;

import com.lidsys.application.search.entity.dto.SearchRequest;

public interface CustomerSearchService
	{

	Map<String, BigDecimal> enrollmentByAge(String programId, String baseQuery, SearchRequest searchRequest);
		
	}
