package com.lidsys.application.search.entity.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryRequest
	{
		private String				name			= "";
		private String				query;
		private Map<String, Object>	dataset;
		private Integer				startPage;
		private Integer				pageSize;
		private List<String>		requiredFields	= new ArrayList<>();
		
		public String getName()
			{
				return name;
			}
			
		public void setName(String name)
			{
				this.name = name;
			}
			
		public String getQuery()
			{
				return query;
			}
			
		public void setQuery(String query)
			{
				this.query = query;
			}
			
		public Map<String, Object> getDataset()
			{
				return dataset;
			}
			
		public void setDataset(Map<String, Object> dataset)
			{
				this.dataset = dataset;
			}
			
		public Integer getStartPage()
			{
				return startPage;
			}
			
		public void setStartPage(Integer startPage)
			{
				this.startPage = startPage;
			}
			
		public Integer getPageSize()
			{
				return pageSize;
			}
			
		public void setPageSize(Integer pageSize)
			{
				this.pageSize = pageSize;
			}
			
		public QueryRequest()
			{
				super();
			}
			
		public QueryRequest(SearchRequest searchRequest, Object[] requestData)
			{
				super();
				query = (String) requestData[0];
				dataset = (LinkedHashMap<String, Object>) requestData[1];
				if (searchRequest.getPage() != null && searchRequest.getSize() != null)
					{
						setStartPage(((searchRequest.getPage().intValue() - 1) * searchRequest.getSize().intValue()));
						setPageSize(searchRequest.getSize().intValue());
					}
			}
			
		public QueryRequest(String name, SearchRequest searchRequest, Object[] requestData)
			{
				super();
				this.name = name;
				query = (String) requestData[0];
				dataset = (LinkedHashMap<String, Object>) requestData[1];
				if (searchRequest.getPage() != null && searchRequest.getSize() != null)
					{
						setStartPage(((searchRequest.getPage().intValue() - 1) * searchRequest.getSize().intValue()));
						setPageSize(searchRequest.getSize().intValue());
					}
			}
	}
