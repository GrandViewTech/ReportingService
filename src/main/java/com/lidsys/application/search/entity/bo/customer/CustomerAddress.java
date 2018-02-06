package com.lidsys.application.search.entity.bo.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lidsys.application.search.entity.bo.customer.constants.AddressEnum;

@Entity
@Table(name = "CUSTOMER_ADDDRESS")
public class CustomerAddress
	{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer		id;
		
		@Column(name = "HEADER")
		private String		header;
		
		@Column(name = "ADRESS_LINE_1", length = 200)
		private String		addressLine1;
		
		@Column(name = "ADRESS_LINE_2", length = 200)
		private String		addressLine2;
		
		@Column(name = "AREA", length = 200)
		private String		area;
		
		@Column(name = "CITY", length = 200)
		private String		city;
		
		@Column(name = "STATE", length = 200)
		private String		state;
		
		@Column(name = "COUNTRY", length = 200)
		private String		country;
		
		@Column(name = "PINCODE", length = 50)
		private String		pincode;
		
		@Column(name = "ADDRESS_TYPE", length = 50)
		@Enumerated(EnumType.STRING)
		private AddressEnum	addressType;
		
		public Integer getId()
			{
				return id;
			}
			
		public void setId(Integer id)
			{
				this.id = id;
			}
			
		public String getAddressLine1()
			{
				return addressLine1;
			}
			
		public void setAddressLine1(String addressLine1)
			{
				this.addressLine1 = addressLine1;
			}
			
		public String getAddressLine2()
			{
				return addressLine2;
			}
			
		public void setAddressLine2(String addressLine2)
			{
				this.addressLine2 = addressLine2;
			}
			
		public String getArea()
			{
				return area;
			}
			
		public void setArea(String area)
			{
				this.area = area;
			}
			
		public String getCity()
			{
				return city;
			}
			
		public void setCity(String city)
			{
				this.city = city;
			}
			
		public String getState()
			{
				return state;
			}
			
		public void setState(String state)
			{
				this.state = state;
			}
			
		public String getCountry()
			{
				return country;
			}
			
		public void setCountry(String country)
			{
				this.country = country;
			}
			
		public String getPincode()
			{
				return pincode;
			}
			
		public void setPincode(String pincode)
			{
				this.pincode = pincode;
			}
			
		public AddressEnum getAddressType()
			{
				return addressType;
			}
			
		public void setAddressType(AddressEnum addressType)
			{
				this.addressType = addressType;
			}
			
		public String getHeader()
			{
				return header;
			}
			
		public void setHeader(String header)
			{
				this.header = header;
			}
			
	}
