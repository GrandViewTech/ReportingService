package com.lidsys.application.search.service.business;

import java.util.Map;

import com.lidsys.application.search.entity.dto.QueryRequest;

public interface SearchService
	{
		Map<String, Object> search(String programId,QueryRequest queryRequest);
	}
