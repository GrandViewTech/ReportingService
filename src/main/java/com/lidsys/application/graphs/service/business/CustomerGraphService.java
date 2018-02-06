package com.lidsys.application.graphs.service.business;

import java.math.BigDecimal;
import java.util.Map;

import com.lidsys.application.search.entity.dto.SearchRequest;

public interface CustomerGraphService
	{
		Map<String, BigDecimal> enrollmentByAge(String programId, SearchRequest searchRequest);
	}
