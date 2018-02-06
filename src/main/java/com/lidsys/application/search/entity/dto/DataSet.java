package com.lidsys.application.search.entity.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataSet
	{
		private String				query;
		private Map<String, Object>	data	= new LinkedHashMap<>();
		
		public Map<String, Object> getData()
			{
				return data;
			}
			
		public void setData(Map<String, Object> data)
			{
				this.data = data;
			}
			
		public String getQuery()
			{
				return query;
			}
			
		public void setQuery(String query)
			{
				this.query = query;
			}
			
		public DataSet(String query, Map<String, Object> data)
			{
				super();
				this.query = query;
				this.data = data;
			}
			
	}
