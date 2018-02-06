package com.lidsys.application.search.entity.bo.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.joda.time.DateTime;

@Embeddable
public class Moment
	{
		@Column(nullable = true)
		private Integer	years		= 0;
		@Column(nullable = true)
		private Integer	monthOfyear	= 0;
		@Column(nullable = true)
		private String	months;
	
		@Column(nullable = true)
		private Integer	dateOfmonth	= 0;
		@Column(nullable = true)
		private String	days;
		@Column(nullable = true)
		private Integer	dayOfweek	= 0;
		@Column(nullable = true)
		private Integer	weekOfmonth	= 0;
		
	
		public Integer getYears()
			{
				return years;
			}

		public void setYears(Integer years)
			{
				this.years = years;
			}

		public Integer getMonthOfyear()
			{
				return monthOfyear;
			}

		public void setMonthOfyear(Integer monthOfyear)
			{
				this.monthOfyear = monthOfyear;
			}

		public String getMonths()
			{
				return months;
			}

		public void setMonths(String months)
			{
				this.months = months;
			}

		public Integer getDateOfmonth()
			{
				return dateOfmonth;
			}

		public void setDateOfmonth(Integer dateOfmonth)
			{
				this.dateOfmonth = dateOfmonth;
			}

		public String getDays()
			{
				return days;
			}

		public void setDays(String days)
			{
				this.days = days;
			}

		public Integer getDayOfweek()
			{
				return dayOfweek;
			}

		public void setDayOfweek(Integer dayOfweek)
			{
				this.dayOfweek = dayOfweek;
			}

		public Integer getWeekOfmonth()
			{
				return weekOfmonth;
			}

		public void setWeekOfmonth(Integer weekOfmonth)
			{
				this.weekOfmonth = weekOfmonth;
			}

		public Moment()
			{
				super();
			}
			
		public Moment(Long time)
			{
				super();
				DateTime dateTime = new DateTime(time);
				this.years = dateTime.getYear();
				this.monthOfyear = dateTime.getMonthOfYear();
				this.months = dateTime.monthOfYear().getAsText();
				this.dateOfmonth = dateTime.getDayOfMonth();
				this.days = dateTime.dayOfMonth().getAsText();
				this.dayOfweek = dateTime.getDayOfWeek();
				this.weekOfmonth = dateTime.getWeekOfWeekyear();
			}
			
	}	