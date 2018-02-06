package com.lidsys.application.graphs.entity.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GRAPH_CONFIG")
public class GraphConfig
	{
		@Id
		@Column(name = "ID", length = 30)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long	id;
		
		@Column(name = "GRAPH_KEY", nullable = false)
		private String	graph;
		
		@Column(name = "BASE_QUERY", nullable = false)
		private String	baseQuery;
		
		@Column(name = "PROGRAM_ID", nullable = false)
		private String	programId;
		
		public String getProgramId()
			{
				return programId;
			}
			
		public void setProgramId(String programId)
			{
				this.programId = programId;
			}
			
		public Long getId()
			{
				return id;
			}
			
		public void setId(Long id)
			{
				this.id = id;
			}
			
		public String getGraph()
			{
				if (graph != null)
					{
						graph = graph.toLowerCase();
					}
				return graph;
			}
			
		public void setGraph(String graph)
			{
				if (graph != null)
					{
						graph = graph.toLowerCase();
					}
				this.graph = graph;
			}
			
		public String getBaseQuery()
			{
				return baseQuery;
			}
			
		public void setBaseQuery(String baseQuery)
			{
				this.baseQuery = baseQuery;
			}
			
		public GraphConfig update(GraphConfig updated)
			{
				setBaseQuery(updated.getBaseQuery());
				return this;
			}

		public GraphConfig()
			{
				super();
			}

		public GraphConfig(String programId, String graph, String baseQuery)
			{
				super();
				this.programId = programId;
				this.graph = graph;
				this.baseQuery = baseQuery;
			}
		
		
			
	}
