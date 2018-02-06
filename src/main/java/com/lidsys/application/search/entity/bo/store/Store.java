package com.lidsys.application.search.entity.bo.store;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lidsys.application.search.entity.bo.common.CommonAttribute;
import com.lidsys.application.search.entity.bo.common.constants.Status;
import com.lidsys.application.search.entity.bo.common.converter.Boolean2StringColumnConverter;

@Entity
@Table(name = "STORE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Store extends CommonAttribute
	{
		@javax.persistence.Id
		private String	storeId;
		@Column(unique = true)
		private String	storeCode;
		private String	legalName;
		private String	name;
		private String	region	= "OTHERS";
		private String	country	= "OTHERS";
		private String	state	= "OTHERS";
		private String	city	= "OTHERS";
		private String	code;
		private String	latitude;
		private String	longitude;
		private String	line1;
		private String	line2;
		private Long	launchDate;
		private Long	operationalSince;
		@Convert(converter = Boolean2StringColumnConverter.class)
		private Boolean	register;
		private String	storeType;
		private Status	status	= Status.ACTIVE;
		
		public Status getStatus()
			{
				return status;
			}
			
		public void setStatus(Status status)
			{
				this.status = status;
			}
			
		public String getStoreCode()
			{
				return storeCode;
			}
			
		public void setStoreCode(String storeCode)
			{
				this.storeCode = storeCode;
			}
			
		public String getLegalName()
			{
				return legalName;
			}
			
		public void setLegalName(String legalName)
			{
				this.legalName = legalName;
			}
			
		public String getName()
			{
				return name;
			}
			
		public void setName(String name)
			{
				this.name = name;
			}
			
		public String getRegion()
			{
				return region;
			}
			
		public void setRegion(String region)
			{
				if (region != null)
					{
						this.region = region;
					}
			}
			
		public String getCountry()
			{
				return country;
			}
			
		public void setCountry(String country)
			{
				if (country != null)
					{
						this.country = country;
					}
			}
			
		public String getState()
			{
				if (state == null)
					{
						state = "";
					}
				return state;
			}
			
		public void setState(String state)
			{
				if (state != null)
					{
						this.state = state;
					}
			}
			
		public String getCity()
			{
				if (city == null)
					{
						city = "";
					}
				return city;
			}
			
		public void setCity(String city)
			{
				if (city != null)
					{
						this.city = city;
					}
					
			}
			
		public String getCode()
			{
				return code;
			}
			
		public void setCode(String code)
			{
				this.code = code;
			}
			
		public String getLatitude()
			{
				return latitude;
			}
			
		public void setLatitude(String latitude)
			{
				this.latitude = latitude;
			}
			
		public String getLongitude()
			{
				return longitude;
			}
			
		public void setLongitude(String longitude)
			{
				this.longitude = longitude;
			}
			
		public String getLine1()
			{
				return line1;
			}
			
		public void setLine1(String line1)
			{
				this.line1 = line1;
			}
			
		public String getLine2()
			{
				return line2;
			}
			
		public void setLine2(String line2)
			{
				this.line2 = line2;
			}
			
		public Boolean getRegister()
			{
				return register;
			}
			
		public void setRegister(Boolean register)
			{
				this.register = register;
			}
			
		public Long getLaunchDate()
			{
				return launchDate;
			}
			
		public void setLaunchDate(Long launchDate)
			{
				this.launchDate = launchDate;
			}
			
		public Long getOperationalSince()
			{
				return operationalSince;
			}
			
		public void setOperationalSince(Long operationalSince)
			{
				this.operationalSince = operationalSince;
			}
			
		public String getStoreType()
			{
				return storeType;
			}
			
		public void setStoreType(String storeType)
			{
				this.storeType = storeType;
			}
			
		public String getStoreId()
			{
				return storeId;
			}
			
		public void setStoreId(String storeId)
			{
				this.storeId = storeId;
			}
			
		public Store update(Store current)
			{
				String id = getStoreId();
				BeanUtils.copyProperties(current, this);
				setStoreId(id);
				return this;
			}
			
		public Store()
			{
				super();
			}
			
	}
