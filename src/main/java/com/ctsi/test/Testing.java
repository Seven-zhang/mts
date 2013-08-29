package com.ctsi.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Testing {

	MessageCenter lg = new MessageCenter();
  @BeforeTest
  public void beforeTest() {
	  lg.setBaseURL();
	  lg.verifyHomepageTitle();	  
  }
  
  @Test
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
		  AssertJUnit.assertEquals(0, exitVal);
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
		  AssertJUnit.assertEquals(0, exitVal);
		  System.out.println("Exit value: " + exitVal);
		  } catch (IOException ex) {
		  System.out.println(ex.toString());
		  }	 	   			 
}
  

  @AfterTest
  public void afterTest() {
	  
	  //lg.endSession();
  }

}
