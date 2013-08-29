package com.ctsi.test;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class PublicTools {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.ie.driver",".\\res\\IEDriverServer.exe");
		
		getWindow();
	
	}
	
	/**
	 * 获取当前窗口的句柄
	 * 
	 */
	public static void getWindow(){
		
		
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
 	    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
 	    WebDriver driver = new InternetExplorerDriver(ieCapabilities);
 	    String currentWindow = driver.getWindowHandle();   
        Set<String> handles = driver.getWindowHandles();
		
		
        Iterator<String> it=handles.iterator();       
        while(it.hasNext()){
        	String handle=it.next();
        	if(currentWindow.equals(handle)){
        	WebDriver window = driver.switchTo().window(handle);        	
        	System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());  
        	return;
        	//break;
        	}
        }
		
		
	}
	
}
