package com.lidsys.application.common.integration.datasource.entity.bo;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lidsys.application.common.integration.datasource.entity.bo.converters.EncryptedColumnConverter;

@Entity
@Table(name = "DB_CONFIG")
public class DbConfig
	{
		@Id
		@Column(name = "ID", length = 30)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long	id;
		
		@Column(name = "PROGRAM_ID", length = 100, nullable = false)
		private String	programId;
		
		@Column(name = "SCHEMA_ID", length = 100, nullable = false)
		private String	schemaId;
		
		@Column(name = "HOST", length = 100, nullable = false)
		private String	host;
		
		@Column(name = "PORT", length = 10, nullable = false)
		private Integer	port;
		
		@Column(name = "USER", length = 200, nullable = false)
		@Convert(converter = EncryptedColumnConverter.class)
		private String	user;
		
		@Column(name = "PASSWORD", length = 200, nullable = false)
		@Convert(converter = EncryptedColumnConverter.class)
		private String	password;
		
		public String getUser()
			{
				return user;
			}
			
		public void setUser(String user)
			{
				this.user = user;
			}
			
		public Long getId()
			{
				return id;
			}
			
		public void setId(Long id)
			{
				this.id = id;
			}
			
		public String getProgramId()
			{
				return programId;
			}
			
		public void setProgramId(String programId)
			{
				this.programId = programId;
			}
			
		public String getSchemaId()
			{
				return schemaId;
			}
			
		public void setSchemaId(String schemaId)
			{
				this.schemaId = schemaId;
			}
			
		public String getHost()
			{
				return host;
			}
			
		public void setHost(String host)
			{
				this.host = host;
			}
			
		public String getPassword()
			{
				return password;
			}
			
		public void setPassword(String password)
			{
				this.password = password;
			}
			
		public Integer getPort()
			{
				return port;
			}
			
		public void setPort(Integer port)
			{
				this.port = port;
			}
			
		public DbConfig update(DbConfig updated)
			{
				setUser(updated.getUser());
				setHost(updated.getHost());
				setPort(updated.getPort());
				setPassword(updated.getPassword());
				setSchemaId(updated.getSchemaId());
				return this;
			}
			
		public DbConfig(String programId, String schemaId, String host, Integer port, String user, String password)
			{
				super();
				this.programId = programId;
				this.schemaId = schemaId;
				this.host = host;
				this.port = port;
				this.user = user;
				this.password = password;
			}
			
		public DbConfig()
			{
				super();
				// TODO Auto-generated constructor stub
			}
			
	}
