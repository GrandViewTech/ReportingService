package com.lidsys.application.search.service.business.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidsys.application.misc.service.plugin.PrintPlugin;
import com.lidsys.application.search.entity.dto.QueryRequest;
import com.lidsys.application.search.service.business.DataSourceService;
import com.lidsys.application.search.service.business.SearchService;
import com.lidsys.application.search.service.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService
	{
		@Autowired
		private SearchRepository	searchRepository;
		
		@Autowired
		private DataSourceService	dataSourceService;
		
		@Override
		public Map<String, Object> search(String programId, QueryRequest queryRequest)
			{
				PrintPlugin.print(" Query Request("+programId+" | " +queryRequest.getName()+ " )",queryRequest);
				EntityManager entityManager = dataSourceService.connection(programId);
				Map<String, Object> responseData = new HashMap<>();
				try
					{
						responseData = searchRepository.search(entityManager, queryRequest);
					}
				finally
					{
						dataSourceService.close(entityManager);
					}
				PrintPlugin.print(" Query Response("+programId+" | " +queryRequest.getName()+ " )",responseData);
				return responseData;
			}
	}
