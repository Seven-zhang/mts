package com.ctsi.test;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.ctsi.tools.BaseCase;

public class TaskManage extends BaseCase{

	MessageCenter lg = new MessageCenter();
 
  @BeforeTest
  public void beforeTest() {
	  lg.setBaseURL();
	  lg.verifyHomepageTitle();	  
  }

 //新建任务 -暂存
  @Test(priority=0)
  public void saveTask() {
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2022")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_name")).sendKeys("拜访中石化");
	  //截至日期对话框
	  lg.driver.findElement(By.id("obj_endTime")).click();
	  lg.driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[4]")).click();
	  lg.driver.findElement(By.xpath("/html/body/div[2]/div[3]/button")).click();
	  lg.driver.findElement(By.id("btn_chooseOutworker")).click();
	  //选择人员对话框    转换框架
	  lg.driver.switchTo().defaultContent();
      WebElement frame1=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame1);
      lg.driver.findElement(By.name("outworkerNumber")).sendKeys("12301270003"); 
      lg.waiter.waitById("outworker_query");
      lg.driver.findElement(By.id("worker_tree_2_check")).click();
      lg.driver.findElement(By.id("bt_save")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.switchTo().frame("if_mainPage");
      lg.driver.findElement(By.id("obj_descr")).sendKeys("了解中石化新领导层");
      //选择模板对话框  转换框架
      lg.driver.findElement(By.id("button")).click();
      lg.driver.switchTo().defaultContent();
      WebElement frame2=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame2);
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/table/tbody/tr/td/div")).click();
      lg.driver.findElement(By.id("btSubmit")).click();
      //地图点选
     /** 
      lg.driver.switchTo().defaultContent();
      lg.driver.switchTo().frame("if_mainPage");     
      lg.driver.findElement(By.id("mapPoint")).click();
      lg.driver.switchTo().defaultContent();
      WebElement frame3=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame3);
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/div/div/div/div/div[3]/div[2]")).click();
      lg.driver.findElement(By.id("ok")).click();
 */     
      lg.driver.switchTo().defaultContent();
      lg.driver.switchTo().frame("if_mainPage"); 
      //上传文件
      WebElement uploadElement = lg.driver.findElement(By.id("fileName"));
      uploadElement.sendKeys("F:\\workspace\\1.jpg");
      //验证提示对话框
      lg.driver.findElement(By.id("isChecked")).click();
      lg.driver.findElement(By.id("smsFlag")).click();
      lg.driver.findElement(By.id("bt_save")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "任务已保存到暂存箱！","验证暂存任务成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
  } 
  
//新建任务 -下发任务
  @Test(priority=1)
  public void sendTask() {
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2022")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_name")).sendKeys("拜访中石化");
	  lg.driver.findElement(By.id("obj_endTime")).click();
	  lg.driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[4]")).click();
	  lg.driver.findElement(By.xpath("/html/body/div[2]/div[3]/button")).click();
	  lg.driver.findElement(By.id("btn_chooseOutworker")).click();
	  lg.driver.switchTo().defaultContent();
      WebElement frame1=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame1);
      lg.driver.findElement(By.name("outworkerNumber")).sendKeys("12301270003"); 
      lg.waiter.waitById("outworker_query");
      lg.driver.findElement(By.id("worker_tree_2_check")).click();
      lg.driver.findElement(By.id("bt_save")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.switchTo().frame("if_mainPage");
      lg.driver.findElement(By.id("obj_descr")).sendKeys("了解中石化新领导层");
      lg.driver.findElement(By.id("button")).click();
      lg.driver.switchTo().defaultContent();
      WebElement frame2=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame2);
      lg.driver.findElement(By.xpath("/html/body/div/form/div/div/table/tbody/tr/td/div")).click();
      lg.driver.findElement(By.id("btSubmit")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.switchTo().frame("if_mainPage"); 
      WebElement uploadElement = lg.driver.findElement(By.id("fileName"));
      uploadElement.sendKeys("F:\\workspace\\1");
      lg.driver.findElement(By.id("isChecked")).click();
      lg.driver.findElement(By.id("smsFlag")).click();
      lg.driver.findElement(By.id("send")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "任务已下发！","验证新建下发任务成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
  } 
  
  //暂存箱 - 下发任务
  @Test(priority=2)
  public void deliveryTask() {
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2023")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("button")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "任务[拜访中石化]已下发！","验证暂存箱下发任务成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
  }  
  
  //删除任务
  @Test(priority=3)
  public void deleteTask() {
	  //暂存箱-删除任务
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2023")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除任务成功","验证暂存箱删除任务成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      //任务派单列表-删除任务
	  lg.driver.findElement(By.id("a_leftMenu_item_2020")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form[2]/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除任务成功","验证任务派单列表删除任务成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      //退回箱-删除任务
	  lg.driver.findElement(By.id("a_leftMenu_item_2024")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除任务成功","验证退回箱删除任务成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      //工作上报记录删除
	  lg.driver.findElement(By.id("a_leftMenu_item_2041")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除任务成功","验证工作上报记录删除成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click(); 
   }   
 
//导出模板数据
  @Test(priority=4)
  public void downloadTaskData() throws InterruptedException {
		//任务模板数据
		  lg.driver.findElement(By.id("a_topMenu_20")).click();
		  lg.driver.findElement(By.id("a_leftMenu_item_2021")).click();
		  lg.driver.switchTo().frame("if_mainPage");
		  lg.driver.findElement(By.xpath("/html/body/div/form/div[2]/div/a/span")).click();		
		  String wget_command = "\"C:/down.exe\"";
		 try {
		  Process exec = Runtime.getRuntime().exec(wget_command);
		  int exitVal = exec.waitFor();
		  Assert.assertEquals(0, exitVal);
		  System.out.println("Exit value: " + exitVal);
		  } catch (IOException ex) {
		  System.out.println(ex.toString());
		  }	  
		 //工作模板数据		
		  lg.driver.findElement(By.id("a_leftMenu_item_2042")).click();
		  lg.driver.switchTo().frame("if_mainPage");
		  lg.driver.findElement(By.xpath("/html/body/div/form/div[2]/div/a/span")).click();		
		  String down_command = "\"C:/download.exe\"";
		 try {
		  Process exec = Runtime.getRuntime().exec(down_command);
		  int exitVal = exec.waitFor();
		  Assert.assertEquals(0, exitVal);
		  System.out.println("Exit value: " + exitVal);
		  } catch (IOException ex) {
		  System.out.println(ex.toString());
		  }	 	   			 
}

  //新建模板
  @Test(priority=5)
  public void createTemple(){
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2065")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.id("obj_title")).sendKeys("中石化拜访模板");
	  lg.driver.findElement(By.id("obj_descr")).sendKeys("准备拜访欧洲财团");
	  lg.driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[3]/td/div/div[2]/button")).click();
	  lg.driver.findElement(By.xpath("/html/body/div[2]/ul/li[4]")).click();	  
	  lg.driver.findElement(By.id("bt_submit")).click();
	  lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "模板信息已保存","验证新建模板成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();	  
  }    
  
  //删除企业模板
  @Test(priority=6)
  public void deleteTemple(){
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2061")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.xpath("/html/body/div/form/div[3]/table/tbody/tr/td/div")).click();
	  lg.driver.findElement(By.id("btDelete")).click();
      lg.driver.switchTo().defaultContent();
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div")).getText(),
    		  "删除企业模板成功","验证删除企业模板成功后提示框中内容是否正确");
      lg.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/a")).click();  
  }    
  
  //查看模板详情
  @Test(priority=6)
  public void seeTemple(){
	  //查看企业模板详情
	  lg.driver.findElement(By.id("a_topMenu_20")).click();
	  lg.driver.findElement(By.id("a_leftMenu_item_2061")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.linkText("详情")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div")).getText(),
    		  "模板详情","验证模板详情弹出框中标题内容是否正确");
      WebElement frame=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame);
      lg.driver.findElement(By.id("btClose")).click();
      //查看模板样例详情
      lg.driver.switchTo().defaultContent();
	  lg.driver.findElement(By.id("a_leftMenu_item_2063")).click();
	  lg.driver.switchTo().frame("if_mainPage");
	  lg.driver.findElement(By.linkText("详情")).click();
      lg.driver.switchTo().defaultContent();
      assertEquals(lg.driver.findElement(By.xpath("/html/body/div/div")).getText(),
    		  "模板样例详情","验证模板样例详情弹出框中标题内容是否正确");
      WebElement frame2=lg.driver.findElement(By.xpath("/html/body/div/div[2]/iframe"));
      lg.driver.switchTo().frame(frame2);
      lg.driver.findElement(By.id("btClose")).click();
  }   
  
 
  
   @AfterTest
   public void afterTest() {
	  lg.endSession();
  }

}
