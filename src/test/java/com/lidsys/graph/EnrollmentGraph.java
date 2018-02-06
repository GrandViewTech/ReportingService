package com.lidsys.graph;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lidsys.TestCase;
import com.lidsys.application.graphs.service.business.CustomerGraphService;
import com.lidsys.application.search.entity.dto.SearchRequest;
import com.lidsys.application.search.entity.dto.constants.FilterCondition;
import com.lidsys.application.search.entity.dto.constants.FilterQuery;

public class EnrollmentGraph extends TestCase
	{
		@Autowired
		private CustomerGraphService customerGraphService;
		
		@Test
		public void enrollmentByAge()
			{
				SearchRequest searchRequest = new SearchRequest();
				//searchRequest.getQueries().add(new SearchQuery("programId", Condition.EQUAL, programId));
				searchRequest.getFilters().add(new FilterQuery("date", FilterCondition.BETWEEN, new HashMap<Integer, Object>()
					{
						private static final long serialVersionUID = -5774936964225381784L;
							
							{
								put(0, "2018-01-07");
								put(1, "2018-02-06");
							}
					}));
				customerGraphService.enrollmentByAge(programId, searchRequest);
			}
	}
