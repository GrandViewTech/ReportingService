package com.lidsys.application.search.entity.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lidsys.application.search.entity.dto.constants.FilterQuery;

public class SearchRequest
	{
		private String				tag;
		private List<SearchQuery>	queries;
		private List<FilterQuery>	filters				= new ArrayList<>();
		private List<String>		requiredTempKeys	= new ArrayList<>();
		private List<String>		requiredKeys		= new ArrayList<>();
		private List<String>		grouping;
		private Map<String, String>	sorts;
		private Integer				page;
		private Integer				size;
		private Map<String, String>	alias;
		private Set<String>			derivedKeys;
		
		public List<String> getRequiredTempKeys()
			{
				if (requiredTempKeys == null)
					{
						requiredTempKeys = new ArrayList<>();
					}
				return requiredTempKeys;
			}
			
		public void setRequiredTempKeys(List<String> requiredTempKeys)
			{
				if (this.requiredTempKeys == null)
					{
						this.requiredTempKeys = new ArrayList<>();
					}
				this.requiredTempKeys = requiredTempKeys;
			}
			
		public Set<String> getDerivedKeys()
			{
				if (derivedKeys == null)
					{
						derivedKeys = new HashSet<>();
					}
				return derivedKeys;
			}
			
		public void addDerivedKey(String key)
			{
				if (this.derivedKeys == null)
					{
						this.derivedKeys = new HashSet<>();
					}
				this.derivedKeys.add(key);
			}
			
		public String getAlias(String key)
			{
				if (alias == null)
					{
						alias = new HashMap<>();
					}
				key = key.toLowerCase().toLowerCase();
				return alias.get(key);
			}
			
		public void addAlias(String key, String value)
			{
				if (this.alias == null)
					{
						this.alias = new HashMap<>();
					}
				key = key.toLowerCase().toLowerCase();
				this.alias.put(key, value);
			}
			
		public Map<String, String> getSorts()
			{
				if (sorts == null)
					{
						sorts = new LinkedHashMap<>();
					}
				return sorts;
			}
			
		public void setSorts(Map<String, String> sorts)
			{
				if (this.sorts == null)
					{
						this.sorts = new LinkedHashMap<>();
					}
				this.sorts = sorts;
			}
			
		public List<String> getGrouping()
			{
				if (grouping == null)
					{
						grouping = new ArrayList<>();
					}
				return grouping;
			}
			
		public void setGrouping(List<String> grouping)
			{
				if (this.grouping == null)
					{
						this.grouping = new ArrayList<>();
					}
				this.grouping = grouping;
			}
			
		public List<SearchQuery> getQueries()
			{
				if (queries == null)
					{
						queries = new ArrayList<>();
					}
				return queries;
			}
			
		public void setQueries(List<SearchQuery> queries)
			{
				if (this.queries == null)
					{
						this.queries = new ArrayList<>();
					}
				this.queries = queries;
			}
			
		public List<FilterQuery> getFilters()
			{
				if (filters == null)
					{
						filters = new ArrayList<>();
					}
				return filters;
			}
			
		public void setFilters(List<FilterQuery> filters)
			{
				if (this.filters == null)
					{
						this.filters = new ArrayList<>();
					}
				this.filters = filters;
			}
			
		public List<String> getRequiredKeys()
			{
				if (requiredKeys == null)
					{
						requiredKeys = new ArrayList<>();
					}
				return requiredKeys;
			}
			
		public void setRequiredKeys(List<String> requiredKeys)
			{
				if (this.requiredKeys == null)
					{
						this.requiredKeys = new ArrayList<>();
					}
				this.requiredKeys = requiredKeys;
			}
			
		public Integer getPage()
			{
				return page;
			}
			
		public void setPage(Integer page)
			{
				this.page = page;
			}
			
		public Integer getSize()
			{
				return size;
			}
			
		public void setSize(Integer size)
			{
				this.size = size;
			}
			
		public String getTag()
			{
				return tag;
			}
			
		public void setTag(String tag)
			{
				this.tag = tag;
			}
			
		public SearchRequest()
			{
				super();
			}
			
		public SearchRequest(List<SearchQuery> queries, List<FilterQuery> filters, List<String> grouping, Map<String, String> sorts, Integer page, Integer size)
			{
				super();
				this.queries = queries;
				this.filters = filters;
				this.grouping = grouping;
				this.sorts = sorts;
				this.page = page;
				this.size = size;
			}
			
	}
