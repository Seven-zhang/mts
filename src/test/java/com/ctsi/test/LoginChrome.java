package com.ctsi.test;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginChrome extends TestCase{

	public static void main(String[] args) {
		
	
		System.setProperty("webdriver.chrome.driver",".\\res\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().getSize();
        // ��¼ҳ��
        driver.get("http://192.9.100.76:60007/mts/main/localInit.ds");
        driver.findElement(By.name("name")).sendKeys("admin@wqzsnew");
        driver.findElement(By.name("PASSWD")).sendKeys("123456");
        Select drpCountry = new Select(driver.findElement(By.name("PROVINCECODE")));
        drpCountry.selectByVisibleText("����");
        driver.findElement(By.name("randNum")).sendKeys("qaz");
       // driver.findElement(By.name("login")).submit();
        driver.findElement(By.name("PASSWD")).submit();
        System.out.println("Page Title is :" + driver.getTitle());
        System.out.println("gouga");
        assertEquals("�й������������",driver.getTitle());
        
        //д����
        WebDriverWait wait = new WebDriverWait(driver,10);  
        wait.until(new ExpectedCondition<WebElement>(){  
            public WebElement apply(WebDriver d) {  
                return d.findElement(By.id("a_topMenu_10"));  
            }}).click();  
   
        //WebElement e6 = driver.findElement(By.id("a_topMenu_10"));
       // e6.click();
        //driver.findElement(By.id("a_leftMenu_item_1013")).click();
        driver.findElement(By.partialLinkText("д����")).click();
        driver.findElement(By.id("btn_chooseOutworker")).click();
        driver.findElement(By.name("outworkerNumber")).sendKeys("18001275116");
        driver.findElement(By.id("outworker_query")).click();
        driver.findElement(By.id("worker_tree_2_check")).click();
        driver.findElement(By.id("bt_save")).click();
        driver.findElement(By.id("obj_content")).sendKeys("�й���");
        driver.findElement(By.id("obj_sign")).sendKeys("zqy");
        driver.findElement(By.id("bt_submit")).submit();

        WebElement e16 = driver.findElement(By.id("div_float15"));
        assertEquals("�����ѷ��ͣ�", e16.getText());
        e16.click();
        
	}
	
	

}
