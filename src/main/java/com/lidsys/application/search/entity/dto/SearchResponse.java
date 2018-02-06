package com.lidsys.application.search.entity.dto;

import java.io.Serializable;

public class SearchResponse<T> implements Serializable
	{
		
		private static final long	serialVersionUID	= -6680864607182958683L;
		private T					payload;
		private Integer				responseCode;
		private String				message;
		private Integer				page;
		private Integer				size;
		private Long				totalSize;
		
		public T getPayload()
			{
				return payload;
			}
			
		public void setPayload(T payload)
			{
				this.payload = payload;
			}
			
		public Integer getResponseCode()
			{
				return responseCode;
			}
			
		public void setResponseCode(Integer responseCode)
			{
				this.responseCode = responseCode;
			}
			
		public String getMessage()
			{
				return message;
			}
			
		public void setMessage(String message)
			{
				this.message = message;
			}
			
		public Integer getPage()
			{
				return page;
			}
			
		public void setPage(Integer page)
			{
				this.page = page;
			}
			
		public Integer getSize()
			{
				return size;
			}
			
		public void setSize(Integer size)
			{
				this.size = size;
			}
			
		public Long getTotalSize()
			{
				return totalSize;
			}
			
		public void setTotalSize(Long totalSize)
			{
				this.totalSize = totalSize;
			}
			
		public SearchResponse()
			{
				super();
			}
			
		public SearchResponse(T payload)
			{
				super();
				this.payload = payload;
			}
			
	}
