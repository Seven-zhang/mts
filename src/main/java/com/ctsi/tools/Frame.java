package com.ctsi.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frame {	
	private WebDriver driver;
	
	public Frame(WebDriver driver){
		this.driver=driver;		
	}
		
	public void switchFrame(String locator){	
		driver.switchTo().defaultContent();
		WebElement frame=driver.findElement(By.xpath(locator));
		driver.switchTo().frame(frame);	
	}    
	
	public void switchMainFrame(String ifame){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(ifame);
		
	}
	
}
