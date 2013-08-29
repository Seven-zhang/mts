package com.ctsi.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver;	
	
	public Wait(WebDriver driver){
		this.driver = driver;	
        PageFactory .initElements(driver, this);
	}
	
	public  void waitForSeconds(int seconds){
		try {
			Thread.sleep(seconds * 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void waitById(final String locator){
		(new WebDriverWait(driver, 15)).until(new ExpectedCondition<WebElement>(){  
	          public WebElement apply(WebDriver d) {  
	              return d.findElement(By.id(locator));  
	          }}).click();
	}
	
	public void waitByXpath(final String xpath){
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<WebElement>(){  
	          public WebElement apply(WebDriver d) {  
	              return d.findElement(By.xpath(xpath));  
	          }}).click();
	}
}
