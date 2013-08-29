package com.ctsi.test;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * mts外勤助手
 *
 */
public class LoginIe8 extends TestCase
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.ie.driver",".\\res\\IEDriverServer.exe");
    	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
 	    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
 	    WebDriver driver = new InternetExplorerDriver(ieCapabilities);
 	    driver.manage().window().maximize();
  
        // 登录
        driver.get("http://192.9.100.76:60007/mts/main/localInit.ds");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("admin@wqzsnew");
        driver.findElement(By.name("PASSWD")).sendKeys("123456");
        Select drpCountry = new Select(driver.findElement(By.name("PROVINCECODE")));
        drpCountry.selectByVisibleText("北京");
        driver.findElement(By.name("randNum")).sendKeys("qaz");
        driver.findElement(By.name("login")).submit();
        System.out.println("Page Title is :" + driver.getTitle());
        assertEquals("中国电信外勤助手", driver.getTitle());
        System.out.println("Page url is :" + driver.getCurrentUrl());
        
        //写短信
        driver.findElement(By.id("a_topMenu_10")).click();;
        WebDriverWait wait = new WebDriverWait(driver,5);  
        wait.until(new ExpectedCondition<WebElement>(){  
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.id("a_leftMenu_item_1013"));  
            }}).click();  

        driver.switchTo().frame("if_mainPage");
        driver.findElement(By.id("btn_chooseOutworker")).click();
        driver.switchTo().defaultContent();
        WebElement frame=driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.name("outworkerNumber")).sendKeys("12301270003");
        
        wait.until(new ExpectedCondition<WebElement>(){  
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.id("outworker_query"));  
            }}).click();  
    
        driver.findElement(By.id("worker_tree_2_check")).click();
        driver.findElement(By.id("bt_save")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("if_mainPage");
        driver.findElement(By.id("obj_content")).sendKeys("中国梦");
        driver.findElement(By.id("obj_sign")).clear();
        driver.findElement(By.id("obj_sign")).sendKeys("zqy");         
        driver.findElement(By.id("bt_submit")).click();
        
        try {
   			Thread.sleep(300);
   		} catch (InterruptedException e) {

   			e.printStackTrace();
   		}
        driver.switchTo().defaultContent();
        String confirm = driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText();
        System.out.println(confirm);
        assertEquals("短信已发送！", confirm);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
        
    }
}





