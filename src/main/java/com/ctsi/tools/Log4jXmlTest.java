package com.ctsi.tools;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


	
	
	public class Log4jXmlTest extends SeleneseTestCase {

	    private static Logger Log = Logger.getLogger(Log4jXmlTest.class.getName());//

	    @Before
		public void setUp() throws Exception {	    	
	    	DOMConfigurator.configure("log4j.xml");
	    	Log.info("______________________________________________________________");
	    	Log.info("Initializing Selenium...");
			selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.google.co.in/");
			selenium.start();
			Log.info("Selenium instance started");
		}

	    @Test
		public void testAdvancedSearch() throws Exception {
	    	Log.info("Opening Google Website");
			selenium.open("http://www.google.com/");
			Log.info("Clicking on advanced search link");
			selenium.click("link=Advanced search");
			selenium.waitForPageToLoad("30000");
			Log.info("Entering search terms");
			selenium.type("as_q", "selenium,selftechy");
			Log.info("Clicking on Advanced Search button");
			selenium.click("//input[@value='Advanced Search']");
			selenium.waitForPageToLoad("30000");
		}

		@After
		public void tearDown() throws Exception {
			Log.info("Stopping Selenium...");
			Log.info("______________________________________________________________");
			selenium.stop();
		}

	}


