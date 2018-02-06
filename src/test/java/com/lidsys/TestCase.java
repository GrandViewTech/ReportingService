package com.lidsys;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lidsys.application.configuration.ApplicationContext;

@ContextConfiguration(classes =
	{ ApplicationContext.class })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestCase
	{
		public static final String	programId	= "4d4d7cfa-5797-4637-a426-085eba5bb2d4";
		public static final String	host		= "192.168.250.232";
		public static final int		port		= 3306;
		public static final String	user		= "root";
		public static final String	password	= "lidsysRoot";
	}
