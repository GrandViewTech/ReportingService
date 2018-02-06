package com.lidsys.application.search.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.lidsys.application.search.entity.dto.constants.Condition;

public class SearchQuery
	{
		private String key;
		private Condition condition = Condition.EQUAL;
		private List<Object> values;

		public String getKey()
			{
				return key;
			}

		public void setKey(String key)
			{
				this.key = key;
			}

		public List<Object> getValues()
			{
				return values;
			}

		public void setValues(List<Object> values)
			{
				this.values = values;
			}

		public Condition getCondition()
			{
				return condition;
			}

		public void setCondition(Condition condition)
			{
				this.condition = condition;
			}

		public SearchQuery()
			{
				super();
			}

		public SearchQuery(String key, List<Object> values)
			{
				super();
				this.key = key;
				this.values = values;
			}

		public SearchQuery(String key, Condition condition, List<Object> values)
			{
				super();
				this.key = key;
				this.condition = condition;
				this.values = values;
			}
		
		public SearchQuery(String key, Condition condition, Object value)
			{
				super();
				this.key = key;
				this.condition = condition;
				if(this.values==null)
					{
						this.values=new ArrayList<>();
					}
				this.values.add(value);
			}
	}
