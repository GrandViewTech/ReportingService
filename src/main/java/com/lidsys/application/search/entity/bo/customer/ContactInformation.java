package com.lidsys.application.search.entity.bo.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lidsys.application.search.entity.bo.customer.constants.ContactType;


@Entity
@Table(name = "CONTACT_INFORMATION")
public class ContactInformation
	{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer		id;
		
		@Column(name = "HEADER")
		private String		header;
		
		@Column(name = "CONTACT_NAME", length = 50)
		private String		contactName;
		
		@Column(name = "CONTACT_DETAILS", length = 50)
		private String		contactDetails;
		
		@Column(name = "CONTACT_TYPE", length = 50)
		@Enumerated(EnumType.STRING)
		private ContactType	contactType;
		
		public Integer getId()
			{
				return id;
			}
			
		public void setId(Integer id)
			{
				this.id = id;
			}
			
		public String getContactDetails()
			{
				return contactDetails;
			}
			
		public void setContactDetails(String contactDetails)
			{
				this.contactDetails = contactDetails;
			}
			
		public ContactType getContactType()
			{
				return contactType;
			}
			
		public void setContactType(ContactType contactType)
			{
				this.contactType = contactType;
			}
			
		public String getContactName()
			{
				return contactName;
			}
			
		public void setContactName(String contactName)
			{
				this.contactName = contactName;
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
