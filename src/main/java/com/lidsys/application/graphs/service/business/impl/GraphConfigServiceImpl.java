package com.lidsys.application.graphs.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidsys.application.graphs.entity.bo.GraphConfig;
import com.lidsys.application.graphs.service.business.GraphConfigService;
import com.lidsys.application.graphs.service.repository.GraphConfigRepository;

@Service
public class GraphConfigServiceImpl implements GraphConfigService
	{
		@Autowired
		private GraphConfigRepository graphConfigRepository;
		
		@Override
		public GraphConfig findByProgramIdAndGraph(String programId, String graph)
			{
				return graphConfigRepository.findByProgramIdAndGraph(programId, graph);
			}
			
		@Override
		public void save(GraphConfig graphConfig)
			{
				String programId = graphConfig.getProgramId();
				GraphConfig existing = findByProgramIdAndGraph(programId, graphConfig.getGraph());
				if (existing == null)
					{
						graphConfigRepository.save(graphConfig);
					}
				else
					{
						graphConfigRepository.save(existing.update(graphConfig));
					}
					
			}
	}
