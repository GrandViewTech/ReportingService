package com.lidsys.application.search.service.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lidsys.application.search.entity.dto.QueryRequest;
import com.lidsys.application.search.service.repository.SearchRepository;

@Service
public class SearchRepositoryImpl implements SearchRepository
	{
		
		private ObjectMapper objectMapper = new ObjectMapper();
		
		@Override
		public Map<String, Object> search(EntityManager entityManager, QueryRequest queryRequest)
			{
				String hql = queryRequest.getQuery();
				Map<String, Object> dataset = queryRequest.getDataset();
				Query typedQuery = entityManager.createQuery(hql);
				for (Map.Entry<String, Object> data : dataset.entrySet())
					{
						String key = data.getKey();
						Object value = data.getValue();
						typedQuery.setParameter(key, value);
					}
				if (queryRequest.getStartPage() != null && queryRequest.getPageSize() != null)
					{
						
						typedQuery.setFirstResult(queryRequest.getStartPage());
						typedQuery.setMaxResults(queryRequest.getPageSize());
					}
				List<List<Object>> result = typedQuery.getResultList();
				if (result.size() > 0)
					{
						Object object = result.get(0);
						return objectMapper.convertValue(object, Map.class);
					}
				return new HashMap<String, Object>();
			}
			
		private List<String> requiredFields(String query)
			{
				List<String> requriedFields = new ArrayList<String>();
				
				return requriedFields;
			}
	}
