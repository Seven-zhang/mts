package com.ctsi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFirefox {

	public static void main(String[] args){
		
		
		System.setProperty("webdriver.firefox.bin","D:\\Program\\firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://192.9.100.76:60007/mts/main/localInit.ds");
        WebElement element = driver.findElement(By.id("a_upBrowser_close"));
        element.click();
        //��¼
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("admin@wqzsnew");
        driver.findElement(By.name("PASSWD")).clear();
        driver.findElement(By.name("PASSWD")).sendKeys("123456");
        Select drpCountry = new Select(driver.findElement(By.name("PROVINCECODE")));
        drpCountry.selectByVisibleText("����");
        driver.findElement(By.name("randNum")).clear();
        driver.findElement(By.name("randNum")).sendKeys("qaz");
        driver.findElement(By.name("PASSWD")).submit();
        //д����
        WebDriverWait wait = new WebDriverWait(driver,30);  
        wait.until(new ExpectedCondition<WebElement>(){  
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.id("a_topMenu_10"));  
            }}).click();  
   
        driver.findElement(By.partialLinkText("д����")).click();
        wait.until(new ExpectedCondition<WebElement>(){  
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.id("obj_workerName"));  
            }}).click();  
        
        
        
        //driver.findElement(By.id("btn_chooseOutworker")).click();
        driver.findElement(By.name("outworkerNumber")).sendKeys("18001275116");
        driver.findElement(By.id("outworker_query")).click();
        driver.findElement(By.id("worker_tree_2_check")).click();
        driver.findElement(By.id("bt_save")).click();
        driver.findElement(By.id("obj_content")).sendKeys("�й���");
        driver.findElement(By.id("obj_sign")).sendKeys("zqy");
        driver.findElement(By.id("bt_submit")).submit();

        WebElement e16 = driver.findElement(By.id("div_float15"));
        e16.click();
        

		
		

	}

}
