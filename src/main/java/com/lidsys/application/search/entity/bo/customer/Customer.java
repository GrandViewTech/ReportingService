package com.lidsys.application.search.entity.bo.customer;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.lidsys.application.search.entity.bo.common.Moment;
import com.lidsys.application.search.entity.bo.common.converter.Boolean2StringColumnConverter;
import com.lidsys.application.search.entity.bo.store.Store;

 
@Entity
@Table(name = "CUSTOMER")
public class Customer
	{
		
		final static org.slf4j.Logger	LOGGER					= org.slf4j.LoggerFactory.getLogger(Customer.class);
		
		@javax.persistence.Id
		private String					customerId;
		
		@Convert(converter = Boolean2StringColumnConverter.class)
		private boolean					ghost;
		
		private String					channel					= "NA";
		
		private String					firstName				= "";
		
		private String					lastName				= "";
		
		private String					gender					= "NA";
		
		private String					maritalStatus			= "NA";
		
		private String					tier					= "NA";
		
		private String					country					= "NA";
		
		private String					city					= "NA";
		
		private String					state					= "NA";
		
		private String					pin						= "NA";
		
		private String					mobile					= "NA";
		
		private String					email					= "NA";
		
		private Integer					age;
		
		private Long					dateOfBirth;
		
		private String					date;
		
		private Long					enrolmentDate;
		
		private String					cashier;
		
		private String					enrolledStoreId;
		
		private String					storeCode;
		
		private String					enrollmentType			= "NA";
		
		@Embedded
		private Moment					moment;
		
		private BigDecimal				accuredPoints			= BigDecimal.ZERO;
		
		private Long					transcationCount		= 0L;
		
		private BigDecimal				totalSpent				= BigDecimal.ZERO;
		
		private BigDecimal				expiredPoints			= BigDecimal.ZERO;
		
		private Long					redemptionCount			= 0L;
		
		private BigDecimal				redeemedPoints			= BigDecimal.ZERO;
		
		private BigDecimal				pointBalance			= BigDecimal.ZERO;
		
		private String					refferalCode			= "";
		
		private BigDecimal				totalRedemeedAmmount	= BigDecimal.ZERO;
		
		@Transient
		private boolean					isUpdate;
		
		public String getCustomerId()
			{
				return customerId;
			}
			
		public void setCustomerId(String customerId)
			{
				this.customerId = customerId;
			}
			
		@OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(nullable = true, name = "fk_storeId", referencedColumnName = "storeId")
		private Store store;
		
		public String getEnrolledStoreId()
			{
				return enrolledStoreId;
			}
			
		public void setEnrolledStoreId(String enrolledStoreId)
			{
				this.enrolledStoreId = enrolledStoreId;
			}
			
		public Store getStore()
			{
				return store;
			}
			
		public void setStore(Store store)
			{
				this.store = store;
			}
			
		public boolean isUpdate()
			{
				return isUpdate;
			}
			
		public void setUpdate(boolean isUpdate)
			{
				this.isUpdate = isUpdate;
			}
			
		public BigDecimal getExpiredPoints()
			{
				return expiredPoints;
			}
			
		public void setExpiredPoints(BigDecimal expiredPoints)
			{
				this.expiredPoints = expiredPoints;
			}
			
		public String getRefferalCode()
			{
				return refferalCode;
			}
			
		public void setRefferalCode(String refferalCode)
			{
				this.refferalCode = refferalCode;
			}
			
		public BigDecimal getPointBalance()
			{
				return pointBalance;
			}
			
		public void setPointBalance(BigDecimal pointBalance)
			{
				this.pointBalance = pointBalance;
			}
			
		public BigDecimal getTotalSpent()
			{
				return totalSpent;
			}
			
		public void setTotalSpent(BigDecimal totalSpent)
			{
				this.totalSpent = totalSpent;
			}
			
		public BigDecimal getRedeemedPoints()
			{
				return redeemedPoints;
			}
			
		public void setRedeemedPoints(BigDecimal redeemedPoints)
			{
				this.redeemedPoints = redeemedPoints;
			}
			
		public Long getRedemptionCount()
			{
				return redemptionCount;
			}
			
		public void setRedemptionCount(Long redemptionCount)
			{
				this.redemptionCount = redemptionCount;
			}
			
		public Long getTranscationCount()
			{
				return transcationCount;
			}
			
		public void setTranscationCount(Long transcationCount)
			{
				this.transcationCount = transcationCount;
			}
			
		public BigDecimal getTotalRedemeedAmmount()
			{
				return totalRedemeedAmmount;
			}
			
		public void setTotalRedemeedAmmount(BigDecimal totalRedemeedAmmount)
			{
				this.totalRedemeedAmmount = totalRedemeedAmmount;
			}
			
		public Integer getAge()
			{
				return age;
			}
			
		public void setAge(Integer age)
			{
				if (age > 0)
					{
						if (age > 100)
							{
								age = 100;
							}
						this.age = age;
					}
			}
			
		public String getFirstName()
			{
				if (firstName == null)
					{
						firstName = "";
					}
				return firstName;
			}
			
		public void setFirstName(String firstName)
			{
				if (firstName == null)
					{
						firstName = "";
					}
				this.firstName = firstName;
			}
			
		public String getLastName()
			{
				if (lastName == null)
					{
						lastName = "";
					}
				return lastName;
			}
			
		public void setLastName(String lastName)
			{
				if (lastName == null)
					{
						lastName = "";
					}
				this.lastName = lastName;
			}
			
		public String getGender()
			{
				return gender;
			}
			
		public void setGender(String gender)
			{
				if (gender != null)
					{
						if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("Male"))
							{
								gender = "MALE".toUpperCase();
							}
						else if (gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Female"))
							{
								gender = "FEMALE".toUpperCase();
							}
						this.gender = gender;
					}
			}
			
		public String getMaritalStatus()
			{
				return maritalStatus;
			}
			
		public void setMaritalStatus(String maritalStatus)
			{
				this.maritalStatus = maritalStatus;
			}
			
		public String getTier()
			{
				return tier;
			}
			
		public void setTier(String tier)
			{
				if (tier != null && tier.trim().length() > 0)
					{
						this.tier = tier;
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
			
		public String getCity()
			{
				return city;
			}
			
		public void setCity(String city)
			{
				if (city != null)
					{
						this.city = city;
					}
					
			}
			
		public String getState()
			{
				return state;
			}
			
		public void setState(String state)
			{
				if (state != null)
					{
						this.state = state;
					}
			}
			
		public String getPin()
			{
				return pin;
			}
			
		public void setPin(String pin)
			{
				this.pin = pin;
			}
			
		public String getMobile()
			{
				if (mobile == null)
					{
						mobile = "";
					}
				return mobile;
			}
			
		public void setMobile(String mobile)
			{
				this.mobile = mobile;
			}
			
		public String getEmail()
			{
				if (email == null)
					{
						email = "";
					}
				return email;
			}
			
		public void setEmail(String email)
			{
				this.email = email;
			}
			
		public Long getDateOfBirth()
			{
				return dateOfBirth;
			}
			
		public Long getEnrolmentDate()
			{
				return enrolmentDate;
			}
			
		public void setEnrolmentDate(Long enrolmentDate)
			{
				this.enrolmentDate = enrolmentDate;
			}
			
		public void setDateOfBirth(Long dateOfBirth)
			{
				this.dateOfBirth = dateOfBirth;
			}
			
		public Moment getMoment()
			{
				return moment;
			}
			
		public String getCashier()
			{
				return cashier;
			}
			
		public void setCashier(String cashier)
			{
				this.cashier = cashier;
			}
			
		public String getEnrollmentType()
			{
				return enrollmentType;
			}
			
		public void setEnrollmentType(String enrollmentType)
			{
				if (enrollmentType != null)
					{
						this.enrollmentType = enrollmentType;
					}
			}
			
		public boolean isGhost()
			{
				return ghost;
			}
			
		public void setGhost(boolean ghost)
			{
				this.ghost = ghost;
			}
			
		public String getDate()
			{
				return date;
			}
			
		public void setDate(String date)
			{
				this.date = date;
			}
			
		public String getStoreCode()
			{
				return storeCode;
			}
			
		public void setStoreCode(String storeCode)
			{
				this.storeCode = storeCode;
			}
			
		public String getChannel()
			{
				return channel;
			}
			
		public void setChannel(String channel)
			{
				this.channel = channel;
			}
			
		public BigDecimal getAccuredPoints()
			{
				return accuredPoints;
			}
			
		public void setAccuredPoints(BigDecimal accuredPoints)
			{
				this.accuredPoints = accuredPoints;
			}
			
	}
