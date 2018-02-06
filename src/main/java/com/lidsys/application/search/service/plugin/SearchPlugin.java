package com.lidsys.application.search.service.plugin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.lidsys.application.search.entity.dto.SearchQuery;
import com.lidsys.application.search.entity.dto.SearchRequest;
import com.lidsys.application.search.entity.dto.constants.FilterQuery;

public class SearchPlugin
	{
		public static String prepareSelect(String view, List<String> requiredKeys)
			{
				if (requiredKeys.size() == 0)
					{
						return view;
					}
				StringJoiner select = new StringJoiner(" ");
				for (String key : requiredKeys)
					{
						select.add(view + "." + key + "  ");
					}
					
				return select.toString();
			}
			
		public static <E> Object[] prepareHql(String view, String baseQuery, SearchRequest request)
			{
				String hql = baseQuery;
				
				Map<String, Object> dataset = new LinkedHashMap<>();
				if (request.getQueries().size() > 0 || request.getFilters().size() > 0)
					{
						hql += " WHERE ";
					}
				// QUERY
				StringJoiner queryJoiner = new StringJoiner(" AND ");
				for (SearchQuery searchQuery : request.getQueries())
					{
						
						switch (searchQuery.getCondition())
							{
								
								case CONTAINS:
									{
										String key = (searchQuery.getKey().contains(".")) ? searchQuery.getKey() : view + "." + searchQuery.getKey();
										queryJoiner.add(key + " LIKE :" + searchQuery.getKey());
										List<Object> like = searchQuery.getValues().parallelStream().filter(ob -> ob instanceof String).map(object -> "%" + object + "%").collect(Collectors.toList());
										dataset.put(searchQuery.getKey(), like);
										break;
									}
								case EQUAL:
									{
										String key = searchQuery.getKey();
										if (key.contains("."))
											{
												String[] keys = StringUtils.split(key, ".");
												key = keys[keys.length - 1];
											}
										String searchKey = (searchQuery.getKey().contains(".")) ? searchQuery.getKey() : view + "." + searchQuery.getKey();
										queryJoiner.add(searchKey + "=:" + key);
										dataset.put(key, searchQuery.getValues());
										break;
									}
								case NOT_NULL:
									{
										String key = (searchQuery.getKey().contains(".")) ? searchQuery.getKey() : view + "." + searchQuery.getKey();
										queryJoiner.add(key + " IS NOT NULL ");
										// dataset.put(searchQuery.getKey(),
										// searchQuery.getValues());
										break;
									}
								default:
									{
										String key = (searchQuery.getKey().contains(".")) ? searchQuery.getKey() : view + "." + searchQuery.getKey();
										queryJoiner.add(key + "=:" + searchQuery.getKey());
										dataset.put(searchQuery.getKey(), searchQuery.getValues());
										break;
									}
							}
					}
				// FILTER
				for (FilterQuery searchQuery : request.getFilters())
					{
						switch (searchQuery.getCondition())
							{
								case BETWEEN:
									{
										StringJoiner data = new StringJoiner(" AND ", " BETWEEN ", " ");
										for (Map.Entry<Integer, Object> value : searchQuery.getValues().entrySet())
											{
												String key = searchQuery.getKey() + "" + value.getKey();
												String attribute = resolveKey(key);
												data.add(" :" + attribute);
												dataset.put(attribute, value.getValue());
											}
											
										queryJoiner.add(searchQuery.getKey() + data.toString());
										break;
									}
								case GREATER_THAN:
									{
										StringJoiner data = new StringJoiner(" AND ", " ", " ");
										for (Map.Entry<Integer, Object> value : searchQuery.getValues().entrySet())
											{
												String key = searchQuery.getKey() + "" + value.getKey();
												String attribute = resolveKey(key);
												data.add(" >:" + attribute);
												dataset.put(attribute, value.getValue());
											}
										queryJoiner.add(searchQuery.getKey() + data.toString());
										break;
									}
							}
					}
				hql += " " + queryJoiner.toString() + " ";
				// QUERY
				if (request.getGrouping() != null && request.getGrouping().size() > 0)
					{
						StringJoiner data = new StringJoiner(" ,  ", " GROUP BY  ", " ");
						for (String qroupBy : request.getGrouping())
							{
								data.add(qroupBy);
							}
						hql += " " + data.toString();
					}
				if (request.getSorts() != null && request.getSorts().size() > 0)
					{
						StringJoiner data = new StringJoiner(" ,  ", " ORDER BY  ", " ");
						for (Map.Entry<String, String> orderBy : request.getSorts().entrySet())
							{
								String key = orderBy.getKey();
								data.add(" " + key + " " + orderBy.getValue() + " ");
							}
						hql += " " + data.toString();
					}
				System.out.println("HQL : " + hql);
				return new Object[]
					{ hql, dataset };
			}
			
		private static String resolveKey(String key)
			{
				if (key.contains("."))
					{
						String[] keys = StringUtils.split(key, ".");
						String attribute = keys[keys.length - 1];
						return attribute;
					}
				else
					{
						return key;
					}
			}
			
	}
