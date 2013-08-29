package com.ctsi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ctsi.tools.BaseCase;

public class CustomerManage extends BaseCase{

	MessageCenter lg = new MessageCenter();
  @BeforeTest
  public void beforeTest() {
	  lg.setBaseURL();
	  lg.verifyHomepageTitle();	  
  }

  @Test(priority=0)
  public void addCustomer() throws InterruptedException {
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("btAdd")).click();
	  //弹出新增客户信息页面，需切换框架
	  lg.driver.switchTo().defaultContent();
      WebElement frame1=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame1);
      lg.driver.findElement(By.id("customerName")).sendKeys("狗噶");
      lg.driver.findElement(By.id("customerCode")).sendKeys("007");
      lg.driver.findElement(By.id("obj_contactPerson")).sendKeys("阳仔");
      lg.driver.findElement(By.id("customerTelephone")).sendKeys("13312345678");
      lg.driver.findElement(By.id("customerEmail")).sendKeys("gouga@ctsi.com");
      lg.driver.findElement(By.id("customerBusinessScope")).sendKeys("五湖四海");
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/div[8]/div/div[2]/button")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[2]/ul/li[3]")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/div[8]/div[2]/div/div[2]/button")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[3]/ul/li[2]")).click();
      Thread.sleep(1000);
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/div[8]/div[2]/div[2]/div/div[2]/button")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[4]/ul/li[5]")).click();
      lg.driver.findElement(By.id("customerAddress")).sendKeys("新街口");
      //选择部门、选择人员、选择客户组---frame嵌套问题未解决
/**   lg.driver.findElement(By.id("addOrganization")).click();
      lg.driver.switchTo().defaultContent();
      WebElement frame2=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame2);
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/ul/li/div")).click();
      lg.driver.findElement(By.id("btSubmit")).click();
*/	  
      lg.driver.findElement(By.id("customerType")).sendKeys("gouga");
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "客户信息已保存！","验证新增客户信息成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();
    }
 
  //转移客户
  @Test(priority=1)
  public void transferCustomer(){
	  
  
  }
  
  //编辑客户
  @Test(priority=2)
  public void editCustomer() throws InterruptedException{	 
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_name")).sendKeys("狗噶");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div/div[5]/a/span")).click();
	  Thread.sleep(1000);
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td[9]/div/a[2]")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame1=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame1);
      lg.driver.findElement(By.id("obj_contactPerson")).clear();
      lg.driver.findElement(By.id("obj_contactPerson")).sendKeys("刘德华");
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "客户信息已保存！","验证编辑客户信息成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();
  }
  
  //查看客户详情
  @Test(priority=3)
  public void viewCustomer() throws InterruptedException{	  
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_name")).sendKeys("狗噶");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div/div[5]/a/span")).click();
	  Thread.sleep(1000);
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td[9]/div/a")).click();
	  lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div")).getText(),
    		  "客户详情","验证客户详情弹出框中标题内容是否正确");
      WebElement frame1=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame1);
      lg.driver.findElement(By.id("btClose")).click();
	  lg.driver.switchTo().defaultContent();
  }
  
  //删除客户
  @Test(priority=4)
  public void deleteCustomer() throws InterruptedException{	  
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_name")).sendKeys("狗噶");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div/div[5]/a/span")).click();
	  Thread.sleep(1000);
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
	  lg.driver.switchTo().defaultContent();
	  lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除客户成功","验证客户删除成功后提示框中标题内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  	 	  
  }  

  //增加客户分组
  @Test(priority=5)
  public void addCustomerGroup() throws InterruptedException{
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4012")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("btAdd")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("groupName")).sendKeys("gouga");
      lg.driver.findElement(By.id("btSubmit")).click();
      Thread.sleep(1000);
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "保存客户组成功","验证客户组增加成功后提示框中标题内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
      lg.driver.switchTo().defaultContent();
    } 
  
  //配置客户分组
  @Test(priority=5)
  public void setCustomerGroup(){
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4012")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[2]/div/ul/li[4]/div")).click();
	  lg.driver.findElement(By.id("btConfig")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      Select drpCountry = new Select(lg.driver.findElement(By.name("allCustomer")));
      drpCountry.selectByVisibleText("新疆买买提");
      lg.driver.findElement(By.id("btTransfer")).click();
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "保存客户组成功","验证客户组配置成功后提示框中标题内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();
    }  
 
//删除客户分组
  @Test(priority=6)
  public void deleteCustomerGroup(){
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4012")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[2]/div/ul/li[4]/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
	  lg.driver.switchTo().defaultContent();
	  lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除客户组成功","验证客户组删除成功后提示框中标题内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
    }  
  
  //客户拜访设置
  @Test(priority=7)
  public void setCustomerVisit(){
	  lg.driver.findElement(By.id("a_topMenu_40")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_4052")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("btSubmit1")).click();
      Select drpTime = new Select(lg.driver.findElement(By.name("effectVisitTimeDesc")));
      drpTime.selectByVisibleText("5分钟");
      Select drpDistince= new Select(lg.driver.findElement(By.name("effectVisitDistinceDesc")));
      drpDistince.selectByVisibleText("100米");
      lg.driver.findElement(By.id("btSubmit1")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "修改客户拜访制度成功","验证客户组删除成功后提示框中标题内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
    }   
  
  
  @AfterTest
  public void afterTest() {
	  lg.endSession();
  }

}
