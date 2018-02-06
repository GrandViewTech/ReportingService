package com.lidsys.application.search.entity.bo.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAMILY_MEMBERS")
public class FamilyMembers
	{
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer	id;
		
		@Column(name = "HEADER")
		private String	header;
		
		@Column(name = "FIRST_NAME", length = 50)
		private String	firstName;
		@Column(name = "LAST_NAME", length = 50)
		private String	lastName;
		@Column(name = "SALUTATION", length = 10)
		private String	salutation;
		@Column(name = "RELATION", length = 50)
		private String	relation;
		@Column(name = "GENDER", length = 20)
		private String	gender;
		@Column(name = "DATE_OF_BIRTH", length = 30)
		private Long	dob;
		@Column(name = "BLOOD_GROUP", length = 30)
		private String	bloodGroup;
		
		@Column(name = "PROFESSION", length = 200)
		private String	profession;
		
		public Integer getId()
			{
				return id;
			}
			
		public void setId(Integer id)
			{
				this.id = id;
			}
			
		public String getFirstName()
			{
				return firstName;
			}
			
		public void setFirstName(String firstName)
			{
				this.firstName = firstName;
			}
			
		public String getLastName()
			{
				return lastName;
			}
			
		public void setLastName(String lastName)
			{
				this.lastName = lastName;
			}
			
		public String getSalutation()
			{
				return salutation;
			}
			
		public void setSalutation(String salutation)
			{
				this.salutation = salutation;
			}
			
		public String getRelation()
			{
				return relation;
			}
			
		public void setRelation(String relation)
			{
				this.relation = relation;
			}
			
		public String getGender()
			{
				return gender;
			}
			
		public void setGender(String gender)
			{
				this.gender = gender;
			}
			
		public Long getDob()
			{
				return dob;
			}
			
		public void setDob(Long dob)
			{
				this.dob = dob;
			}
			
		public String getBloodGroup()
			{
				return bloodGroup;
			}
			
		public void setBloodGroup(String bloodGroup)
			{
				this.bloodGroup = bloodGroup;
			}
			
		public String getProfession()
			{
				return profession;
			}
			
		public void setProfession(String profession)
			{
				this.profession = profession;
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
