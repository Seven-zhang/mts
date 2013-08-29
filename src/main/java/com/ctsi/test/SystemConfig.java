package com.ctsi.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ctsi.tools.BaseCase;

public class SystemConfig extends BaseCase{

	MessageCenter lg = new MessageCenter();	
	
  @BeforeTest
  public void beforeTest() {
	  lg.setBaseURL();
	  lg.verifyHomepageTitle();	
  }
  
  //编辑员工信息
  @Test(priority=0)
  public void editEmployee() throws InterruptedException{
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("workerName")).sendKeys("杜中");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div/div[4]/a/span")).click();
	  Thread.sleep(1000);
	  lg.driver.findElement(By.linkText("编辑")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("worker_comments")).clear();
      lg.driver.findElement(By.id("worker_comments")).sendKeys("Let's handwork");
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "修改企业外勤人员成功","验证修改企业外勤人员成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();	  
  }
  
  //查看员工详情
  @Test(priority=1)
  public void viewEmployee() throws InterruptedException{	  
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("workerName")).sendKeys("杜中");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div/div[4]/a/span")).click();
	  Thread.sleep(1000);
	  lg.driver.findElement(By.linkText("详情")).click();
	  lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div")).getText(),
    		  "外勤人员详情","验证外勤人员详情弹出框标题内容是否正确");
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("btClose")).click();
	  lg.driver.switchTo().defaultContent();
  }
  
  //修改员工工作区域
  @Test(priority=2)
  public void editEmployeeDomain() throws InterruptedException{
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("workerName")).sendKeys("杜中");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div/div[4]/a/span")).click();
      Thread.sleep(1000);
      lg.driver.findElement(By.xpath("/html/body/div/form[2]/div[3]/table/tbody/tr/td/div")).click();
      lg.driver.findElement(By.id("modifyOutworkderArea")).click();      
      lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[2]/div[2]/div/div[2]/button")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[3]/ul/li[3]")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[2]/div[2]/div[2]/div/div[2]/button")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[4]/ul/li[2]")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/button")).click();
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div[5]/ul/li[3]")).click();
      lg.driver.findElement(By.id("addRegion")).click();      
      lg.driver.findElement(By.id("btSubmit")).click();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "修改企业外勤人员工作区域成功","验证修改企业外勤人员工作区域成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();
    }
  
  //取消定位功能
  @Test(priority=3)
  public void cancelPosition() throws InterruptedException{
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("workerName")).sendKeys("杜中");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div/div[4]/a/span")).click();
      Thread.sleep(1000);
      lg.driver.findElement(By.xpath("/html/body/div/form[2]/div[3]/table/tbody/tr/td/div")).click();
      lg.driver.findElement(By.id("unActivateOutworkder")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a/span")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "去激活请求已经发出","验证取消定位功能成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
    }  
  
  //激活定位功能
  @Test(priority=4)
  public void activatePosition() throws InterruptedException{
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7011")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("workerName")).sendKeys("杜中");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div/div[4]/a/span")).click();
      Thread.sleep(1000);
      lg.driver.findElement(By.xpath("/html/body/div/form[2]/div[3]/table/tbody/tr/td/div")).click();
      lg.driver.findElement(By.id("activateOutworkder")).click(); 
      lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "激活请求已经发出","验证激活定位功能成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();
    }   
 
 
//增加部门
  @Test(priority=5)
  public void addDept(){	  
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7013")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/div/ul/li/div")).click();
	  lg.driver.findElement(By.id("btAdd")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
	  lg.driver.findElement(By.id("organizationName")).sendKeys("gouga");
	  lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "添加部门成功","验证添加部门成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
      lg.driver.switchTo().defaultContent();
  }  

  //配置部门
  @Test(priority=6)
  public void setDept(){
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7013")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[2]/div/ul/li/ul/li[11]/div")).click();
	  lg.driver.findElement(By.id("btConfig")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "配置部门成功","验证配置部门成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
      lg.driver.switchTo().defaultContent();
    } 
  
  //删除部门
  @Test(priority=7)
  public void deleteDept(){
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7013")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/div/ul/li/ul/li[11]/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
	  lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a/span")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除成功","验证删除部门成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
    }  

  
  //修改企业基本信息
  @Test(priority=8)
  public void editBasicInfo(){
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7031")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_industry")).clear();
	  lg.driver.findElement(By.id("obj_industry")).sendKeys("CTSIICT");
      lg.driver.findElement(By.id("bt_submit")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "保存基本信息成功！","验证修改企业基本信息成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
    }  
  
  //企业logo设置
  @Test(priority=9)
  public void setLogo(){
	  //修改企业logo图片
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7032")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  WebElement uploadfile = lg.driver.findElement(By.id("upload"));
	  uploadfile.sendKeys("F:\\workspace\\1.jpg");
	  lg.driver.findElement(By.id("btSubmit")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "企业LOGO修改成功！","验证企业LOGO修改成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
      //恢复企业logo默认配置
      lg.driver.switchTo().frame("if_mainPage");
      lg.driver.findElement(By.id("btDefault")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "企业LOGO修改成功！","验证恢复企业LOGO默认配置成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
    }   
  
  //编辑登录账号信息
  @Test(priority=10)
  public void editAcount(){
	  lg.driver.findElement(By.id("a_topMenu_70")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_7035")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("loginName")).sendKeys("test@wqzsnew");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div/div[4]/a/span")).click();
      lg.driver.findElement(By.linkText("编辑")).click();
      lg.driver.switchTo().defaultContent();
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("loginUser_personName")).clear();
      lg.driver.findElement(By.id("loginUser_personName")).sendKeys("于杰的帐号");
      lg.driver.findElement(By.id("btSubmit")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "修改平台用户成功","验证编辑登录账号信息成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
    }  
  
  @AfterTest
  public void afterTest() {
	  lg.driver.quit();
  }

}
