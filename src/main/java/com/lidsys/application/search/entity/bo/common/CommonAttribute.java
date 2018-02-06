package com.lidsys.application.search.entity.bo.common;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class CommonAttribute
	{
		@JsonIgnore
		private Integer	version;
		
		private Long	creationDate;
		
		private Long	lastModifiedDate;
		
		private String	programId;
		
		public String getProgramId()
			{
				return programId;
			}
			
		public void setProgramId(String programId)
			{
				this.programId = programId;
			}
			
		public Integer getVersion()
			{
				return version;
			}
			
		public void setVersion(Integer version)
			{
				this.version = version;
			}
			
		public Long getCreationDate()
			{
				return creationDate;
			}
			
		public void setCreationDate(Long creationDate)
			{
				this.creationDate = creationDate;
			}
			
		public Long getLastModifiedDate()
			{
				return lastModifiedDate;
			}
			
		public void setLastModifiedDate(Long lastModifiedDate)
			{
				this.lastModifiedDate = lastModifiedDate;
			}
			
	}
