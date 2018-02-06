package com.lidsys.application.search.service.business.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lidsys.application.common.integration.datasource.entity.bo.DbConfig;
import com.lidsys.application.common.integration.datasource.service.business.DbConfigService;
import com.lidsys.application.search.service.business.DataSourceService;
import com.lidsys.application.search.service.plugin.DataSoucePlugin;

@Service
public class DataSourceServiceImpl implements DataSourceService
	{
		
		@Autowired
		private DataSoucePlugin						dataSoucePlugin;
		
		@Autowired
		private DbConfigService						dbConfigService;
		
		private Map<String, EntityManagerFactory>	programId_entityManagerFactory	= new LinkedHashMap<>();
		
		@Override
		public EntityManager connection(String programId)
			{
				programId = programId.toLowerCase();
				EntityManagerFactory entityManagerFactory = programId_entityManagerFactory.get(programId);
				if (entityManagerFactory == null)
					{
						DbConfig dbConfig = dbConfigService.findByProgramId(programId);
						entityManagerFactory = dataSoucePlugin.entityManagerFactory(dbConfig.getHost(), dbConfig.getPort(), dbConfig.getSchemaId(), dbConfig.getUser(), dbConfig.getPassword());
						programId_entityManagerFactory.put(programId, entityManagerFactory);
					}
				return programId_entityManagerFactory.get(programId).createEntityManager();
			}
			
		@Override
		public EntityTransaction transaction(EntityManager entityManager)
			{
				EntityTransaction entityTransaction = entityManager.getTransaction();
				if (!entityManager.isJoinedToTransaction())
					{
						entityTransaction.begin();
					}
				return entityTransaction;
			}
			
		@Override
		public void rollback(EntityManager entityManager, EntityTransaction entityTransaction)
			{
				entityManager.close();
			}
			
		@Override
		public void rollback(EntityTransaction entityTransaction)
			{
				if (entityTransaction.isActive())
					{
						entityTransaction.rollback();
					}
			}
			
		@Override
		public void close(EntityManager entityManager)
			{
				if (entityManager != null && entityManager.isOpen())
					{
						entityManager.close();
					}
			}
			
		@Override
		public void commit(EntityManager entityManager, EntityTransaction entityTransaction)
			{
				commit(entityTransaction);
				close(entityManager);
				
			}
			
		@Override
		public void commit(EntityTransaction entityTransaction)
			{
				if (entityTransaction.isActive())
					{
						entityTransaction.commit();
					}
					
			}
			
	}
