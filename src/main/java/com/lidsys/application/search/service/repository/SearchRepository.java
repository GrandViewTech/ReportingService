package com.lidsys.application.search.service.repository;

import java.util.Map;

import javax.persistence.EntityManager;

import com.lidsys.application.search.entity.dto.QueryRequest;

public interface SearchRepository
	{
		public Map<String, Object> search(EntityManager entityManager, QueryRequest queryRequest);
	}
