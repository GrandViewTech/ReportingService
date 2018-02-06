package com.lidsys.application.search.service.plugin;

import java.beans.PropertyVetoException;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;

import com.lidsys.application.misc.service.plugin.LidsysUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Service
public class DataSoucePlugin
	{
		
		private final static Logger	LOGGER	= LoggerFactory.getLogger(DataSoucePlugin.class);
		
		@Value(value = "${spring.jdbc.driverClass}")
		public String				driverClass;
		
		@Value("${preferredTestQuery}")
		public String				preferredTestQuery;
		
		@Value("${generateHbm2ddl}")
		public Boolean				hbm2ddl	= false;
		
		// @Async
		public EntityManagerFactory entityManagerFactory(String host, Integer port, String schemaId, String user, String password)
			{
				String jdbcUrl = "jdbc:mysql://" + host + ":" + port;
				HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
				vendorAdapter.setGenerateDdl(false);
				vendorAdapter.setShowSql(false);
				LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
				factory.setJpaVendorAdapter(vendorAdapter);
				factory.setPackagesToScan("com.lidsys.application.search.entity.bo");
				factory.setDataSource(dataSource(jdbcUrl, schemaId, user, password));
				Properties jpaProperties = new Properties();
				jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
				jpaProperties.put("hibernate.default_schema", schemaId);
				jpaProperties.put("hibernate.connection.autocommit", false);
				if (hbm2ddl)
					{
						jpaProperties.put("hibernate.hbm2ddl.auto", "update");
					}
				// jpaProperties.put("hibernate.show_sql", "true");
				factory.setJpaProperties(jpaProperties);
				Map<String, Object> jpaPropertyMap = factory.getJpaPropertyMap();
				factory.setJpaPropertyMap(jpaPropertyMap);
				factory.afterPropertiesSet();
				return factory.getObject();
			}
			
		public DataSource dataSource(String jdbcUrl, String schemaId, String user, String password)
			{
				String url = jdbcUrl;
				if (schemaId != null && !LidsysUtil.isEmpty(schemaId))
					{
						url += "/" + schemaId;
					}
				url += "?autoReconnect=true&useSSL=false";
				LOGGER.info("CONNECTING : " + url);
				ComboPooledDataSource dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
				try
					{
						dataSource.setDriverClass(driverClass);
						dataSource.setUser(user);
						dataSource.setPassword(password);
						dataSource.setJdbcUrl(url);
						dataSource.setInitialPoolSize(1);
						dataSource.setMinPoolSize(1);
						dataSource.setMaxPoolSize(3);
						dataSource.setAcquireIncrement(1);
						dataSource.setMaxIdleTime(60 * 1);
						dataSource.setMaxIdleTimeExcessConnections(600);
						dataSource.setPreferredTestQuery(preferredTestQuery);
						dataSource.setIdleConnectionTestPeriod(60);
						dataSource.setTestConnectionOnCheckin(true);
						dataSource.setTestConnectionOnCheckout(true);
					}
				catch (PropertyVetoException propertyVetoException)
					{
						LOGGER.error(propertyVetoException.getLocalizedMessage(), propertyVetoException);
					}
				return dataSource;
			}
	}
