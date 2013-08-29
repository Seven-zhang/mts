package com.ctsi.testlink;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ctsi.tools.BaseCase;
import com.ctsi.tools.Log;

import testlink.api.java.client.TestLinkAPIResults;


	public class DemoSelenium extends BaseCase implements IConstantes {
	 
		private String baseurl="http://192.9.100.76:60007/mts/main/localInit.ds";
		public  WebDriver driver;
		static  String resultado = null;
		static  String msg = null;
		  //初始化对象
		  @BeforeClass
		  public void setBaseURL(){
			  PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties"); 			
			  System.setProperty("webdriver.ie.driver",".\\res\\IEDriverServer.exe");
			  DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			  ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			  driver = new InternetExplorerDriver(ieCapabilities);
			  driver.manage().window().maximize();	  
			  driver.get(baseurl);
		  }
		  
		  //登录系统
		  @Test()
		public void verifyHomepageTitle() throws Exception{
			  try
			  {
			  Log.comment("测试用例：登录外勤助手");     	  
			  driver.findElement(By.name("name")).clear();
		      driver.findElement(By.name("name")).sendKeys("admin@wqzsnew");
		      Log.comment("测试步骤1：输入用户名");     	  
		      driver.findElement(By.name("PASSWD")).sendKeys("123456");
		      Log.comment("测试步骤2：输入密码");     	  
		      Select drpCountry = new Select(driver.findElement(By.name("PROVINCECODE")));		     
		      drpCountry.selectByVisibleText("北京");	
		      Log.comment("测试步骤3：选择区域");   
		      driver.findElement(By.name("randNum")).sendKeys("qaz");
		      Log.comment("测试步骤4：输入验证码");  
		      driver.findElement(By.name("login")).submit();
		      Log.comment("测试步骤5：点击登录按钮");  
		      assertEquals(driver.getTitle(),"中国电信外勤助手","验证外勤助手主页面标题是否正确");
		      Log.comment("登录外勤助手成功");     	  
		      resultado = TestLinkAPIResults.TEST_PASSED;	
			  }		
			  catch (Exception e) {
			  resultado = TestLinkAPIResults.TEST_FAILED;
			  msg = e.getMessage();
			  e.printStackTrace();
			  }
			  finally {
				  TestClass.reportTestCaseResult(IConstantes.PROJETO, IConstantes.PLANO,IConstantes.CASO_TESTE1, IConstantes.BUILD, msg, resultado);
			  }
		}
		  
		  @AfterTest
		  public void endSession(){
			  driver.quit();
		  } 		      

	}

