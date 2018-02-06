package com.lidsys.application.misc.service.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class PrintPlugin
	{
		private static final Logger	LOGGER			= LoggerFactory.getLogger(PrintPlugin.class);
		
		private static ObjectMapper	objectMapper	= new ObjectMapper();
		private static ObjectWriter	objectWriter	= objectMapper.writerWithDefaultPrettyPrinter();
		private static Boolean		allowPrinting	= true;
		
		public static void print(String message, Object object)
			{
				if (allowPrinting)
					{
						try
							{
								if (object != null)
									{
										String json = objectWriter.writeValueAsString(object);
										System.out.println(message + " " + json);
									}
							}
						catch (Exception exception)
							{
								LOGGER.error("Unable To Perform Print Option : " + exception.getLocalizedMessage());
							}
					}
				else
					{
						LOGGER.warn("Printing is Disable");
					}
			}
	}
