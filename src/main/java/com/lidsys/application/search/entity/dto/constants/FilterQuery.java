package com.lidsys.application.search.entity.dto.constants;

import java.io.Serializable;
import java.util.Map;


public class FilterQuery implements Serializable
	{
		private static final long		serialVersionUID	= 4335107470005584201L;
		private String					key;
		private FilterCondition			condition			= FilterCondition.BETWEEN;
		private Map<Integer, Object>	values;
		
		public String getKey()
			{
				return key;
			}
			
		public void setKey(String key)
			{
				this.key = key;
			}
			
		public Map<Integer, Object> getValues()
			{
				return values;
			}
			
		public void setValues(Map<Integer, Object> values)
			{
				this.values = values;
			}
			
		public FilterCondition getCondition()
			{
				return condition;
			}
			
		public void setCondition(FilterCondition condition)
			{
				this.condition = condition;
			}
			
		public FilterQuery()
			{
				super();
			}
			
		public FilterQuery(String key, Map<Integer, Object> values)
			{
				super();
				this.key = key;
				this.values = values;
			}
			
		public FilterQuery(String key, FilterCondition condition, Map<Integer, Object> values)
			{
				super();
				this.key = key;
				this.condition = condition;
				this.values = values;
			}
	}
