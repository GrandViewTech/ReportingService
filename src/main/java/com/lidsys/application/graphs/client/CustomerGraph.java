package com.lidsys.application.graphs.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidsys.application.graphs.service.business.CustomerGraphService;
import com.lidsys.application.misc.service.plugin.PrintPlugin;
import com.lidsys.application.search.entity.dto.SearchRequest;

@RestController
@CrossOrigin
@RequestMapping("graph/api/program/{programId}")
public class CustomerGraph
	{
		@Autowired
		private CustomerGraphService customerGraphService;
		
		
		@PostMapping(value = "/enrolmentByAge")
		public void enrollmentByAge(@PathVariable("programId") String programId, @RequestBody SearchRequest searchRequest)
			{
				PrintPlugin.print("",searchRequest);
			}
	}
