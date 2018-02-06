package com.lidsys.application.search.service.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface DataSourceService
	{
		public EntityManager connection(String programId);
		
		public EntityTransaction transaction(EntityManager entityManager);
		
		public void rollback(EntityManager entityManager, EntityTransaction entityTransaction);
		
		public void rollback(EntityTransaction entityTransaction);
		
		public void close(EntityManager entityManager);
		
		public void commit(EntityManager entityManager, EntityTransaction entityTransaction);
		
		public void commit(EntityTransaction entityTransaction);
		
	}
