package com.lidsys.application.search.service.plugin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import com.lidsys.application.search.entity.dto.SearchRequest;

@Service
public class ValidateSearchFieldPlugin
	{
		private Map<String, Set<String>> class_field = new HashMap<>();
		
		//@PostConstruct
		public void init()
			{
				try
					{
						ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
						ImmutableSet<ClassInfo> classInfos = ClassPath.from(classLoader).getTopLevelClassesRecursive("com.lidsys.application.searchengine.entity.bo");
						for (ClassInfo classInfo : classInfos)
							{
								Class classz = Class.forName(classInfo.getName());
								if (!classz.isEnum())
									{
										Set<String> fields = new HashSet<>();
										for (Field field : classz.getDeclaredFields())
											{
												fields.add(field.getName());
											}
										class_field.put(classz.getSimpleName().toLowerCase(), fields);
									}
							}
					}
				catch (Exception exception)
					{
						exception.printStackTrace();
					}
					
			}
			
		public void validate(String entity, SearchRequest searchRequest)
			{/*
				List<ResponseError> errors = new ArrayList<>();
				Set<String> fields = class_field.get(entity.toLowerCase());
				for (SearchQuery searchQuery : searchRequest.getQueries())
					{
						if (!fields.contains(searchQuery.getKey()))
							{
								errors.add(new ResponseError(1, "Invalid Field " + searchQuery.getKey()));
							}
					}
				if (errors.size() > 0)
					{
						throw new InvalidFieldException("Invalid Field Used In SearchQuery", errors);
					}
			*/}
	}
