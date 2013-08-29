package com.ctsi.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ctsi.page.Login;
import com.ctsi.tools.BaseCase;
import com.ctsi.tools.Frame;
import com.ctsi.tools.Log;
import com.ctsi.tools.Wait;
import com.ctsi.tools.HTMLReport;

public class MessageCenter extends BaseCase{		
	private String baseurl="http://192.9.100.76:60007/mts/main/localInit.ds";
	public  WebDriver driver;
	public Wait waiter;
	public Frame framer;
	private  Map<String, Boolean> log = new HashMap();
	private HTMLReport res = new HTMLReport();
	private long duration;
	private long startime;
	private long endtime;
	private int i = 0;
	private String prefix = "mtsTest_";	
	public static Logger logger = Logger.getLogger(MessageCenter.class);
	
  //初始化对象
  @BeforeClass
  public void setBaseURL(){
	  PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties"); 
	  //DOMConfigurator.configure(".\\src\\main\\resources\\log4j.xml");
  	  logger.info("______________________________________________________________");
  	  logger.info("Initializing Selenium...");
  	  logger.debug("gouga");
	  System.setProperty("webdriver.ie.driver",".\\res\\IEDriverServer.exe");
	  DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	  ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	  driver = new InternetExplorerDriver(ieCapabilities);
	  waiter=new Wait(driver);
	  framer=new Frame(driver);
	  driver.manage().window().maximize();	  
	  driver.get(baseurl);
	  logger.info("Selenium instance started");
	  try {
		res.generateReport();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }
  
  //登录系统
  @Test(groups = { "Login" },priority= 0,description = "登录外勤助手主页面")
public void verifyHomepageTitle() {
	  Login lg=new Login(driver);
	  lg.inputName("admin@wqzsnew");
	  //driver.findElement(By.name("name")).clear();
     // driver.findElement(By.name("name")).sendKeys("admin@wqzsnew");
      log.put("step1:输入用户名", true);
     
      //driver.findElement(By.name("PASSWD")).sendKeys("123456");
      lg.inputPaasWd("123456");
      log.put("step2:输入密码", true);
      //下拉窗
      //Select drpCountry = new Select(driver.findElement(By.name("PROVINCECODE")));
      //drpCountry.selectByVisibleText("北京");
      lg.choiceArea("北京");
      log.put("step3:选择所在地区", true);
      //driver.findElement(By.name("randNum")).sendKeys("qaz");
      lg.inputRandNum("qaz");
      log.put("step4:输入验证码", true);
      //driver.findElement(By.name("login")).submit();
      lg.loginMts();
      log.put("step5:点击登录按钮", true);   
      assertEquals(driver.getTitle(),"中国电信外勤助手","验证外勤助手主页面标题是否正确");
      Log.comment("登录系统成功");
  }

  //写短信
  @Test(groups = { "Message" },priority= 2,description = "选择某人写短信")
public void writeSMS(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1013");
      driver.switchTo().frame("if_mainPage");
      driver.findElement(By.id("btn_chooseOutworker")).click();
      framer.switchFrame("/html/body/div/div[2]/iframe");
      driver.findElement(By.name("outworkerNumber")).sendKeys("12301270003");
      waiter.waitById("outworker_query");
      waiter.waitById("worker_tree_2_check");
      driver.findElement(By.id("bt_save")).click(); 
      log.put("step1:选择人员", true);
      framer.switchMainFrame("if_mainPage");
      driver.findElement(By.id("button")).click();         
      framer.switchFrame("/html/body/div/div[2]/iframe");
      driver.findElement(By.xpath("/html/body/div/form/div/div/table/tbody/tr/td/div")).click();
      driver.findElement(By.id("btSubmit")).click();  
      log.put("step2:选择短信", true);
      framer.switchMainFrame("if_mainPage");
      driver.findElement(By.id("obj_content")).sendKeys("中国梦");
      log.put("step3:输入短信内容", true);
      driver.findElement(By.id("obj_sign")).clear();
      driver.findElement(By.id("obj_sign")).sendKeys("ctsi");
      log.put("step4输入签名", true);
      driver.findElement(By.id("bt_submit")).click();
      log.put("step5:点击发送按钮", true);
 	  waiter.waitForSeconds(1);
      driver.switchTo().defaultContent();
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"短信已发送！",
    		  "验证写短信成功后提示框中内容是否正确");
      Log.comment("发送短信成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
  }

  //写通知
  @Test(groups = { "Message" },priority= 5,description = "选择某人写通知")
public void writeNote(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1032");
      driver.switchTo().frame("if_mainPage");
      driver.findElement(By.id("obj_name")).sendKeys("党员开会");
      log.put("step1:输入通知标题", true);
      driver.findElement(By.id("btn_chooseOutworker")).click();
      framer.switchFrame("/html/body/div/div[2]/iframe");
      driver.findElement(By.name("outworkerNumber")).sendKeys("12301270003"); 
      waiter.waitById("outworker_query");
      waiter.waitById("worker_tree_2_check");
      driver.findElement(By.id("bt_save")).click();
      log.put("step2:选择人员", true);
      framer.switchMainFrame("if_mainPage");
      driver.findElement(By.id("button")).click();         
      framer.switchFrame("/html/body/div/div[2]/iframe");
      driver.findElement(By.xpath("id('4089e4cc3ff13264013ff601171501f7_check')")).click();  
      driver.findElement(By.id("btSubmit")).click();
      log.put("step3:选择通知样例", true);
      framer.switchMainFrame("if_mainPage");   
      driver.findElement(By.id("obj_content")).sendKeys("中国需要改革");  
      log.put("step4:通知内容", true);
      driver.findElement(By.id("bt_submit")).click();
      log.put("step5:点击发送按钮", true);
 	  waiter.waitForSeconds(1);
      driver.switchTo().defaultContent();
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"通知已发送！",
    		  "验证写通知成功后提示框中内容是否正确");
      Log.comment("发送通知短信成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
  }

  //删除通知记录
  @Test(groups = { "Message" },priority= 6,description = "删除刚发送的通知记录")
public void deleteNote(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1031");
      driver.switchTo().frame("if_mainPage");
      driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
      log.put("step1:选择新增的通知", true);
      driver.findElement(By.id("btDelete")).click();
      log.put("step2:点击删除按钮", true);
      driver.switchTo().defaultContent();
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"删除通知成功",
    		  "验证删除通知成功后提示框中内容是否正确");
      Log.comment("删除通知记录成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
  }
 
  //增加短信模板
  @Test(groups = { "Message" },priority= 1,description = "增加短信模板")
public void addSmsTemplet(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1051");
      driver.switchTo().frame("if_mainPage");
      driver.findElement(By.id("btAdd")).click();
      log.put("step1:点击增加按钮", true);
      framer.switchFrame("/html/body/div/div[2]/iframe");
      driver.findElement(By.id("obj_content")).sendKeys("暴雨蓝色预警");
      log.put("step2:输入短信模板内容", true);
      driver.findElement(By.id("bt_submit")).click();
      log.put("step3:点击确定按钮", true);
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"新增短信模板成功！",
    		  "验证新增短信模板成功后提示框中内容是否正确");
      Log.comment("增加短信模板成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
      driver.switchTo().defaultContent();
   }
 
  //删除短信模板  
  @Test(groups = { "Message" },priority= 3,description = "删除刚新增的短信模板  ")
public void deleteSmsTemplet(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1051");
      driver.switchTo().frame("if_mainPage");
      driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
      log.put("step1:选择新增的短信模板", true);
      driver.findElement(By.id("btDelete")).click();
      log.put("step2:点击删除按钮", true);
      driver.switchTo().defaultContent();
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"删除短信模板成功",
    		  "验证删除短信成功后提示框中内容是否正确");
      Log.comment("删除短信模板成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");  
  }
  
  //增加通知模板 
  @Test(groups = { "Message" },priority= 4,description = "增加通知模板")
public void addNoteTemplet(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1052");
      driver.switchTo().frame("if_mainPage");
      driver.findElement(By.id("btAdd")).click();
      log.put("step1:点击增加按钮", true);
      framer.switchFrame("/html/body/div/div[2]/iframe");
      driver.findElement(By.id("obj_content")).sendKeys("暴雨黄色预警");
      log.put("step2:输入通知模板内容", true);
      driver.findElement(By.id("bt_submit")).click();
      log.put("step3:点击确定按钮", true);
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"新增通知模板成功！",
    		  "验证新增通知模板成功后提示框中内容是否正确");
      Log.comment("增加通知模板成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
      driver.switchTo().defaultContent();
  }
  
  //删除通知模板
   @Test(groups = { "Message" },priority= 7,description = "删除刚新增的通知模板")
public void deleteNoteTemplet(){
	  driver.findElement(By.id("a_topMenu_10")).click();
	  waiter.waitById("a_leftMenu_item_1052");
	  driver.switchTo().frame("if_mainPage");
      driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
      log.put("step1:选择新增的通知模板", true);
      driver.findElement(By.id("btDelete")).click();
      log.put("step2:点击删除按钮", true);
      driver.switchTo().defaultContent();
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");
      assertEquals(driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),"删除通知成功",
    		  "验证删除通知成功后提示框中内容是否正确");
      Log.comment("删除通知模板成功");
      waiter.waitByXpath("/html/body/div/div[2]/div/div[2]/a");	  
  } 

  //生成报告
  @AfterMethod
  public void am(ITestResult result) throws Exception {
		int testno = i++;
		endtime = System.currentTimeMillis();
		duration = endtime - startime;		
		res.sendStatusToReport(testno, prefix+testno, duration/1000, "test", result,log);	
	}


  //对象销毁
  @AfterTest
  public void endSession(){
	  driver.quit();
  } 
  
}
